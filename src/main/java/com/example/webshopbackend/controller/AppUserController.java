package com.example.webshopbackend.controller;

import com.example.webshopbackend.dto.UserDtoRequest;
import com.example.webshopbackend.dto.UserDtoResponse;
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
    public List<UserDtoResponse> findAll(@RequestParam(required = false, defaultValue = "") String usrcont){
        return appUserService.findAll(usrcont);
    }

    @GetMapping("/{id}")
    public AppUser findById(@PathVariable int id) {
        return appUserService.findById(id);
    }

    @PostMapping("/post")
    public UserDtoResponse appUser(@RequestBody UserDtoRequest userDtoRequest){
        return appUserService.addAppUser(userDtoRequest);
    }

}
