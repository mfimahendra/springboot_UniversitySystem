package com.nuistindo.UniversitySystem.service;

import com.nuistindo.UniversitySystem.model.TeachersModel;
import com.nuistindo.UniversitySystem.repository.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TeachersServiceImpl implements TeachersService{
    private final TeachersRepository teachersRepository;

    public TeachersServiceImpl(TeachersRepository teachersRepository) { this.teachersRepository = teachersRepository; }
    public Iterable<TeachersModel> listAllTeachers() { return teachersRepository.findAllByOrderByIdAsc(); }
    public TeachersModel findOneTeacher(String id) { return teachersRepository.findOneById(id).orElse(null); }

    public TeachersModel registerTeachers(String id, String name, String expertise, String password) {
        if (id == null || password == null) {
            return null;
        } else {
            TeachersModel teacher = new TeachersModel();
            teacher.setId(id);
            teacher.setName(name);
            teacher.setExpertise(expertise);
            teacher.setPassword(password);
            return teachersRepository.save(teacher);
        }
    }

    public TeachersModel updateTeacher(String id, String name, String expertise, String password) {
        if (name == null || password == null) {
            return null;
        } else {
            TeachersModel teacher = teachersRepository.findOneById(id).orElse(null);
            teacher.setId(id);
            teacher.setName(name);
            teacher.setExpertise(expertise);
            teacher.setPassword(password);
            return teachersRepository.save(teacher);
        }
    }

    @Transactional
    public void deleteTeacher(String id) { teachersRepository.removeById(id); }
}
