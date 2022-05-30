package com.nuistindo.UniversitySystem.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student_table")
public class StudentsModel {
    @Id

    private String id;
    private String name;
    private String gender;
    private String major;
    private String country;
    private String password;

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

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }
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

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentsModel that = (StudentsModel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(gender, that.gender) && Objects.equals(major, that.major) && Objects.equals(country, that.country) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, major, country, password);
    }

    @Override
    public String toString() {
        return "StudentsModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", major='" + major + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
