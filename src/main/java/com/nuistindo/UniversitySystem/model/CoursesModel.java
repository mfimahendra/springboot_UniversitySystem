package com.nuistindo.UniversitySystem.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "courses_table")
public class CoursesModel {

    @Id

    private String id;

    private String course;

    private String faculty;

    private String teacher_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoursesModel that = (CoursesModel) o;
        return Objects.equals(id, that.id) && Objects.equals(course, that.course) && Objects.equals(faculty, that.faculty) && Objects.equals(teacher_id, that.teacher_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, course, faculty, teacher_id);
    }

    @Override
    public String toString() {
        return "CoursesModel{" +
                "id='" + id + '\'' +
                ", course='" + course + '\'' +
                ", faculty='" + faculty + '\'' +
                ", teacher_id='" + teacher_id + '\'' +
                '}';
    }
}
