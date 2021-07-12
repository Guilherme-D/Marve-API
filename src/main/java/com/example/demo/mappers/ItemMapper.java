package com.example.demo.mappers;

import com.example.demo.dto.ItemRequest;
import com.example.demo.models.Item;
import com.example.demo.models.ItemType;
import com.example.demo.models.ListContent;
import com.example.demo.service.ItemTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ItemMapper {
    @Autowired
    private static ItemTypeService itemTypeService;

    public static Item toItem(ItemRequest itemRequest, ListContent listContent){
        String type_name = (null == itemRequest.getType()) ? "" : itemRequest.getType();
        ItemType type = Optional.of(itemTypeService.findByName(type_name))
                .orElseGet(() -> itemTypeService.create(new ItemType(type_name)));

        return new Item(itemRequest.getResourceURI(),
                itemRequest.getName(),
                type, listContent );
    }
}
