package com.example.demo.service;

import com.example.demo.dto.ItemRequest;
import com.example.demo.models.Item;

public interface ItemService {

    Item create(ItemRequest itemRequest);
}
