package com.nuistindo.UniversitySystem.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student_table")
public class StudentsModel {
    @Id

    String id;

    String name;

    String major;

    String country;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentsModel that = (StudentsModel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(major, that.major) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, major, country);
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
