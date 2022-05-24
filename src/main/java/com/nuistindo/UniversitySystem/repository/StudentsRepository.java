package com.nuistindo.UniversitySystem.repository;

import com.nuistindo.UniversitySystem.model.StudentsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentsRepository extends JpaRepository<StudentsModel, Integer> {

    Optional<StudentsModel> findOneById(String id);

    List<StudentsModel> findAllByOrderByIdAsc();

    Optional<StudentsModel> removeById(String id);

}
