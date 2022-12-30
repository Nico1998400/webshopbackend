package com.example.webshopbackend.services;

import com.example.webshopbackend.dto.UserDtoRequest;
import com.example.webshopbackend.dto.UserDtoResponse;
import com.example.webshopbackend.enitites.AppUser;
import com.example.webshopbackend.enitites.Role;
import com.example.webshopbackend.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AppUserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    private final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<UserDtoResponse> findAll(String contains){
        return appUserRepository
                .findAppUsersByUsernameContaining(contains)
                .stream()
                .map(appUser -> new UserDtoResponse(appUser.getId(), appUser.getUsername()))
                .toList();
    }

    public AppUser findById(int id) {
        return appUserRepository.findById(id).orElseThrow();
    }

    public UserDtoResponse addAppUser(UserDtoRequest userDtoRequest) {

        AppUser existingAppUser = appUserRepository.save(new AppUser(userDtoRequest.username(), passwordEncoder.encode(userDtoRequest.password()), List.of(Role.USER)));

        return new UserDtoResponse(existingAppUser.getId(), existingAppUser.getUsername());
    }
}
