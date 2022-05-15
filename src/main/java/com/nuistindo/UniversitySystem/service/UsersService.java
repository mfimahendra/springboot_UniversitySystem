package com.nuistindo.UniversitySystem.service;

import com.nuistindo.UniversitySystem.model.UsersModel;
import com.nuistindo.UniversitySystem.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersModel registerUser(String username, String password) {
        if (username == null || password == null) {
            return null;
        } else {
            UsersModel user = new UsersModel();
            user.setUsername(username);
            user.setPassword(password);
            return usersRepository.save(user);
        }
    }

    public UsersModel authenticate(String username, String password) {
        return usersRepository.findByUsernameAndPassword(username, password).orElse(null);
    }
}
