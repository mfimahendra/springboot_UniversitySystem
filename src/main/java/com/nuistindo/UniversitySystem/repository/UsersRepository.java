package com.nuistindo.UniversitySystem.repository;

import com.nuistindo.UniversitySystem.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel, Integer> {

    Optional<UsersModel> findByUsernameAndPassword(String username, String password);

}
