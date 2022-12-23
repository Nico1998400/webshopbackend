package com.example.webshopbackend.controller;

import com.example.webshopbackend.enitites.AppUser;
import com.example.webshopbackend.services.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AppUserService appUserService;

    public AuthController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegistrationDto appUserDto) {
        AppUser appUser = AppUserService.registerNewUserAccount(appUserDto);
        return new ResponseEntity<>(appUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDto loginDto) {
        String token = appUserService.login(loginDto);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        appUserService.logout(request);
        return ResponseEntity.ok().build();
    }
}
