package com.nuistindo.UniversitySystem.service;

import com.nuistindo.UniversitySystem.model.StudentsModel;
import com.nuistindo.UniversitySystem.model.UsersModel;
import com.nuistindo.UniversitySystem.repository.StudentsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StudentsServiceImpl implements StudentsService{

    private final StudentsRepository studentsRepository;

    public StudentsServiceImpl(StudentsRepository studentsRepository) { this.studentsRepository = studentsRepository; }

    public Iterable<StudentsModel> listAllStudents() { return studentsRepository.findAll(); }

    public Iterable<StudentsModel> findAllByOrderByIdAsc() { return studentsRepository.findAllByOrderByIdAsc(); }

    public StudentsModel findOneStudent(String id) {
        return studentsRepository.findOneById(id).orElse(null);
    }

    public StudentsModel registerStudents(String student_id, String name, String major, String country) {
        if (student_id == null || name == null) {
            return null;
        } else {
            StudentsModel student = new StudentsModel();
            student.setId(student_id);
            student.setName(name);
            student.setMajor(major);
            student.setCountry(country);
            return studentsRepository.save(student);
        }
    }

    public StudentsModel updateStudent(String id, String name, String major, String country) {
        if (id == null || name == null) {
            return null;
        } else {
            StudentsModel student = studentsRepository.findOneById(id).orElse(null);
            student.setId(id);
            student.setName(name);
            student.setMajor(major);
            student.setCountry(country);
            return studentsRepository.save(student);
        }
    }

    @Transactional
    public void deleteStudent(String id) {
        studentsRepository.removeById(id);
    }
}
