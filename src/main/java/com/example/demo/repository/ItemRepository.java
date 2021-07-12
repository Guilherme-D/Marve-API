package com.example.demo.repository;

import com.example.demo.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {

    List<Item> findAllByListContentId(Long id);
}
