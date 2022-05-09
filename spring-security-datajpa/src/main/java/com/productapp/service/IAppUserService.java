package com.productapp.service;

import com.productapp.model.AppUser;

public interface IAppUserService {
    void addUser(AppUser appUser);



    void updateUser(AppUser appUser);


    void deleteUser(int userId);






}
