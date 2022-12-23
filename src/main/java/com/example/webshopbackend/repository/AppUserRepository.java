package com.example.webshopbackend.repository;


import com.example.webshopbackend.enitites.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository <AppUser, Integer> {

}
