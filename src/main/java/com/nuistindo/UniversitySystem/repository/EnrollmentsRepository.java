package com.nuistindo.UniversitySystem.repository;

import com.nuistindo.UniversitySystem.model.EnrollmentsModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnrollmentsRepository extends JpaRepository<EnrollmentsModel, Integer> {

}
