package com.example.demo.service.impl;

import com.example.demo.models.ItemType;
import com.example.demo.repository.ItemTypeRepository;
import com.example.demo.service.ItemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ItemTypeServiceImpl implements ItemTypeService {

    @Autowired
    private ItemTypeRepository itemTypeRepository;

    @Override
    public ItemType findByName(String name) {
        return Optional.ofNullable(this.itemTypeRepository.findByName(name))
                .orElseGet(() -> this.create(new ItemType(name)));
    }

    @Override
    public List<ItemType> findAllByName(String name) {
        if(null == name){
            System.out.println("null");
        }
        return Optional.of(this.itemTypeRepository.findAllByName(name))
                .orElseThrow(() -> new NoSuchElementException("Tipo não encontrado!"));
    }

    @Override
    public ItemType create(ItemType listType) {
        /*Optional<ItemType> byName = Optional.ofNullable(this.itemTypeRepository.findByName(listType.getName()));
        return !byName.isPresent() ? this.itemTypeRepository.save(listType) : byName;
        */
        return Optional.ofNullable(this.itemTypeRepository.findByName(listType.getName()))
                .orElseGet(() -> this.itemTypeRepository.save(listType));
    }


}
