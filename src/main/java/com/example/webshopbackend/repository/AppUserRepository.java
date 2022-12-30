package com.example.webshopbackend.repository;


import com.example.webshopbackend.enitites.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository <AppUser, Integer> {

    List<AppUser> findAppUsersByUsernameContaining(String containing);

    Optional<AppUser> findAppUsersByUsernameIgnoreCase(String username);

}
