package com.example.demo.repository;

import com.example.demo.models.Thumbnail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThumbnailRepository extends JpaRepository<Thumbnail,Long> {

    Thumbnail findByCharacterId(Long id);
}
