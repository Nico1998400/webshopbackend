package com.example.webshopbackend.services;

import com.example.webshopbackend.enitites.AppUser;
import com.example.webshopbackend.repository.AppUserRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    public AppUser findById(int id) {
        return appUserRepository.findById(id).orElseThrow();
    }

    public AppUser addAppUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }
}
