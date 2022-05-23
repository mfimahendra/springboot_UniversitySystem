package com.nuistindo.UniversitySystem.service;

import com.nuistindo.UniversitySystem.model.UsersModel;
import com.nuistindo.UniversitySystem.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
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

    public UsersModel updateAdmin(Integer id,String username, String password) {
        if (username == null || password == null) {
            return null;
        } else {
            UsersModel user = usersRepository.getById(id);
            user.setUsername(username);
            user.setPassword(password);
            return usersRepository.save(user);
        }
    }

    public UsersModel authenticate(String username, String password) {
        return usersRepository.findByUsernameAndPassword(username, password).orElse(null);
    }

    public Iterable<UsersModel> listAllUsers() {
        return usersRepository.findAll();
    }

    public void deleteUser(Integer id) {
        usersRepository.deleteById(id);
    }

    public Object getUserById(int id) {
        return usersRepository.findById(id);
    }
}
