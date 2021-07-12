package com.example.demo.service.impl;

import com.example.demo.models.ItemType;
import com.example.demo.models.ListType;
import com.example.demo.repository.ItemTypeRepository;
import com.example.demo.repository.ListTypeRepository;
import com.example.demo.service.ListTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ListTypeServiceImpl implements ListTypeService {

    @Autowired
    private ListTypeRepository listTypeRepository;

    @Override
    public ListType findByName(String stories) {
        return this.listTypeRepository.findOneByName(stories);
    }
}
