package com.nuistindo.UniversitySystem.repository;

import com.nuistindo.UniversitySystem.model.CoursesModel;
import com.nuistindo.UniversitySystem.model.StudentsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public interface CoursesRepository extends JpaRepository<CoursesModel, Integer> {

    List<CoursesModel> findAllByOrderByIdAsc();

    Optional<CoursesModel> findOneById(String id);

    Optional<CoursesModel> removeById(String id);

}
