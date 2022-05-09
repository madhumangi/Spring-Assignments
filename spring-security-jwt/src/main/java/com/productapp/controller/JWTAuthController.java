package com.productapp.controller;

import com.productapp.model.JWTUser;
import com.productapp.service.JWTUserServiceImpl;
import com.productapp.util.JWTTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JWTAuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;
        @Autowired
        private JWTUserServiceImpl jwtUserService;

        @Autowired
        private JWTTokenUtil jwtTokenUtil;
        @Autowired
        private AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody JWTUser user){
        String username= user.getUsername();
        String password=passwordEncoder.encode(user.getPassword());
        JWTUser jwtUser=new JWTUser(username,password);

        //save in db
        jwtUserService.addUser(jwtUser);
        return ResponseEntity.ok("added");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody JWTUser user){

        authenticate(user.getUsername(),user.getPassword());
        //check if username is in db
        UserDetails details=jwtUserService.loadUserByUsername(user.getUsername());
        //generate the token with the userdata received from db
        String jwtToken=jwtTokenUtil.generateToken(details);
        //return the token in the response
        return ResponseEntity.ok(jwtToken);
    }
    //to specify the type of authentication
    private void authenticate(String username,String password){
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(username, password);
            authenticationManager.authenticate(authenticationToken);
        }catch(BadCredentialsException e) {
            System.out.println("Invalid credentials");
        }catch (DisabledException e){
            System.out.println("disabled");
        }
    }

    @GetMapping("/greet")
    public String greet(){
        return "JWT is too lengthy";
    }
}
