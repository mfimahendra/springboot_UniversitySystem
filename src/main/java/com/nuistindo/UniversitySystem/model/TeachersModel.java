package com.nuistindo.UniversitySystem.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teacher_table")
public class TeachersModel {

    @Id
    String id;
    String name;
    String expertise;
    String password;

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

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeachersModel that = (TeachersModel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(expertise, that.expertise) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, expertise, password);
    }

    @Override
    public String toString() {
        return "TeachersModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", expertise='" + expertise + '\'' +
                '}';
    }
}
