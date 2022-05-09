package com.productapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {


    @Column(unique = true,length = 20)
    private String username;
    private String password;
    @Id
    @GeneratedValue
    private Integer userId;


    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
