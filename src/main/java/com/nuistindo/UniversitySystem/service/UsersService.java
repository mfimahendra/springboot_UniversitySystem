package com.nuistindo.UniversitySystem.service;

import com.nuistindo.UniversitySystem.model.UsersModel;

public interface UsersService {

    Iterable<UsersModel> listAllUsers();
    UsersModel registerUser(String username, String password);
    UsersModel authenticate(String username, String password);
    UsersModel updateAdmin(Integer id, String username, String password);

    void deleteUser(Integer id);

}
