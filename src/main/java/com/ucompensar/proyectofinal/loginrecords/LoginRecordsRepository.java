package com.ucompensar.proyectofinal.loginrecords;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginRecordsRepository extends JpaRepository<LoginRecords, Long> {

    List<LoginRecords> findByUsuarioId(Long usuarioId);
}