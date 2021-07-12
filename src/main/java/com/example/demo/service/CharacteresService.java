package com.example.demo.service;

import com.example.demo.dto.CharacterDataWrapper;
import com.example.demo.models.Characteres;

public interface CharacteresService {

    CharacterDataWrapper findAll(Integer limit, Integer page_number, Long character_id);


}
