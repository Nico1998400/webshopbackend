package com.example.webshopbackend.controller;

import com.example.webshopbackend.enitites.AppUser;
import com.example.webshopbackend.services.AppUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000/"})
@RestController

@RequestMapping("/api/appuser")
public class AppUserController {

    private AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping
    public List<AppUser> findAll(){
        return appUserService.findAll();
    }

    @GetMapping("/{id}")
    public AppUser findById(@PathVariable int id) {
        return appUserService.findById(id);
    }

    @PostMapping("/post")
    public AppUser appUser(@RequestBody AppUser appUser){
        return appUserService.addAppUser(appUser);
    }

}
