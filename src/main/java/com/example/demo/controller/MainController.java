package com.example.demo.controller;

import com.example.demo.dto.CharacterDataWrapper;
import com.example.demo.service.CharacteresService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/v1/public/characters")
public class MainController {

    @Autowired
    private CharacteresService characteresService;

    @GetMapping(path = "")
    @ApiOperation(value = "Lista todos os personagens")
    public ResponseEntity<CharacterDataWrapper> listCharacter(
            @RequestParam Integer limit,
            @RequestParam Integer page_number
    ) {
        return ResponseEntity.ok()
                .body(this.characteresService.findAll(limit, page_number, -1L));
    }

    @GetMapping(path = "/{characterID}")
    @ApiOperation(value = "Busca um personagem pelo id")
    public ResponseEntity<CharacterDataWrapper> listCharacterById(
            @PathVariable Long characterID
    ) {
        return ResponseEntity.ok()
                .body(this.characteresService.findAll(1,0,characterID));
    }

    @GetMapping(path = "/{characterID}/comics")
    @ApiOperation(value = "Busca as revistas de um personagem")
    public ResponseEntity<String> listCharacterComics(
            @PathVariable Long characterID
    ) {
        return ResponseEntity.ok()
                .body("Still in development");
    }
    @GetMapping(path = "/{characterID}/events")
    @ApiOperation(value = "Lista todos os eventos de um personagem")
    public ResponseEntity<String> listCharacterEvents(
            @PathVariable Long characterID
    ) {
        return ResponseEntity.ok()
                .body("Still in development");
    }
    @GetMapping(path = "/{characterID}/series")
    @ApiOperation(value = "Lista todas as speries de um personagem")
    public ResponseEntity<String> listCharacterSeries(
            @PathVariable Long characterID
    ) {
        return ResponseEntity.ok()
                .body("Still in development");
    }
    @GetMapping(path = "/{characterID}/stories")
    @ApiOperation(value = "Lista todas as historias de um personagem")
    public ResponseEntity<String> listCharacterStories(
            @PathVariable Long characterID
    ) {
        return ResponseEntity.ok()
                .body("Still in development");
    }
}