package com.nuistindo.UniversitySystem.service;

import com.nuistindo.UniversitySystem.model.StudentsModel;

public interface StudentsService {

    Iterable<StudentsModel> listAllStudents();

    Iterable<StudentsModel> findAllByOrderByIdAsc();

    StudentsModel findOneStudent(String id);

    StudentsModel registerStudents(String student_id, String name, String gender, String major, String country, String password);

    void deleteStudent(String id);

}
