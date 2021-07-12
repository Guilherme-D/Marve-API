package com.example.demo.service;

import com.example.demo.models.ItemType;

import java.util.List;

public interface ItemTypeService {
    ItemType findByName(String name);

    List<ItemType> findAllByName(String name);

    ItemType create(ItemType listType);
}
