package com.example.demo.repository;

import com.example.demo.models.ListType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListTypeRepository extends JpaRepository<ListType,Long> {


    ListType findOneByName(String name);
}
