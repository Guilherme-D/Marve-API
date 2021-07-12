package com.example.demo.repository;

import com.example.demo.models.Characteres;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CharacteresRepository extends JpaRepository<Characteres,Long> {

    Page<Characteres> findAll(Pageable page);

    Page<Characteres> findAllById(Long id, Pageable page);
}
