package com.example.demo.repository;

import com.example.demo.models.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UrlRepository extends JpaRepository<Url,Long> {

    List<Url> findAllByCharacterId(Long id);
}
