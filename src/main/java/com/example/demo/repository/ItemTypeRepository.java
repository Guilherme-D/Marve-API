package com.example.demo.repository;

import com.example.demo.models.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemTypeRepository extends JpaRepository<ItemType,Long> {

    ItemType findByName(String name);

    List<ItemType> findAllByName(String name);
}
