package com.productapp.controllers;

import com.productapp.model.AppUser;
import com.productapp.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserController {

    private PasswordEncoder passwordEncoder;
    private IAppUserService appUserService;
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setAppUserService(IAppUserService appUserService) {
        this.appUserService = appUserService;
    }
    @PostMapping("/")
    public void addUser(@RequestBody AppUser appUser){
        String username=appUser.getUsername();
        String password=appUser.getPassword();
        //encode the password before saving it to db
        String encodedPassword=passwordEncoder.encode(password);
        AppUser user=new AppUser(username,encodedPassword);
        appUserService.addUser(user);



    }
}
