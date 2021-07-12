package com.example.demo.service.impl;

import com.example.demo.dto.ItemRequest;
import com.example.demo.models.Item;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item create(ItemRequest itemRequest) {
        return null;
    }
}
