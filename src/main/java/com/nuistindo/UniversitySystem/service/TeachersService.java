package com.nuistindo.UniversitySystem.service;

import com.nuistindo.UniversitySystem.model.TeachersModel;

public interface TeachersService {

    Iterable<TeachersModel> listAllTeachers();

    TeachersModel findOneTeacher(String id);
    TeachersModel registerTeachers(String id, String name, String expertise, String password);
    TeachersModel updateTeacher(String id, String name, String expertise, String password);
    void deleteTeacher(String id);

}
