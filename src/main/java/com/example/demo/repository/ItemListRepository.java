package com.example.demo.repository;

import com.example.demo.models.ItemList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemListRepository extends JpaRepository<ItemList,Long> {

}
