package com.nuistindo.UniversitySystem.service;

import com.nuistindo.UniversitySystem.model.CoursesModel;
import com.nuistindo.UniversitySystem.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CoursesServiceImpl implements CoursesService{
    private final CoursesRepository coursesRepository;

    public CoursesServiceImpl(CoursesRepository coursesRepository) { this.coursesRepository = coursesRepository; }

    public Iterable<CoursesModel> findAll() { return coursesRepository.findAll(); }

    public Iterable<CoursesModel> findAllByOrderByIdAsc() { return coursesRepository.findAllByOrderByIdAsc(); }

    public CoursesModel findOneCourse(String id) { return coursesRepository.findOneById(id).orElse(null); }

    public CoursesModel addCourse(String id, String course_name, String faculty, String teacher_id) {
        if (id == null || course_name == null) {
            return null;
        } else {
            CoursesModel course = new CoursesModel();
            course.setId(id);
            course.setCourse(course_name);
            course.setFaculty(faculty);
            course.setTeacher_id(teacher_id);
            return coursesRepository.save(course);
        }
    }

    public CoursesModel updateCourse(String id, String course_name, String faculty, String teacher_id) {
        if (id == null || course_name == null) {
            return null;
        } else {
            CoursesModel course = coursesRepository.findOneById(id).orElse(null);
            course.setId(id);
            course.setCourse(course_name);
            course.setFaculty(faculty);
            course.setTeacher_id(teacher_id);
            return coursesRepository.save(course);
        }
    }

    @Transactional
    public void deleteCourse(String id){ coursesRepository.removeById(id); }


}
