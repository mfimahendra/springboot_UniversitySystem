package com.nuistindo.UniversitySystem.service;

import com.nuistindo.UniversitySystem.model.CoursesModel;

public interface CoursesService {

    Iterable<CoursesModel> findAllByOrderByIdAsc();

    CoursesModel findOneCourse(String id);

    CoursesModel addCourse(String id, String course_name, String faculty, String teacher_id);

    CoursesModel updateCourse(String id, String course_name, String faculty, String teacher_id);

    void deleteCourse(String id);

}
