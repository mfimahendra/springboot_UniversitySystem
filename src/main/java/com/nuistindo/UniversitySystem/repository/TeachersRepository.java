package com.nuistindo.UniversitySystem.repository;

import com.nuistindo.UniversitySystem.model.TeachersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeachersRepository extends JpaRepository<TeachersModel, Integer> {

    List<TeachersModel> findAllByOrderByIdAsc();
    Optional<TeachersModel> findOneById(String id);
    Optional<TeachersModel> removeById(String id);
}
