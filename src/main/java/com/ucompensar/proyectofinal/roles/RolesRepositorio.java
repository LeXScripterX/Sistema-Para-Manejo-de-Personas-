package com.ucompensar.proyectofinal.roles;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepositorio extends JpaRepository<RolesClass, Long> {

    Optional<RolesClass> findById(Long id);

}