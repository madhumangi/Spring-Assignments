package com.productapp.repository;

import com.productapp.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser,Integer> {

    AppUser findByUsername(String username);




}
