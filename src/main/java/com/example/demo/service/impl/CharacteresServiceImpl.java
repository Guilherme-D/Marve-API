package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.models.*;
import com.example.demo.repository.*;
import com.example.demo.service.CharacteresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CharacteresServiceImpl implements CharacteresService {

    @Autowired
    private CharacteresRepository characteresRepository;

    @Autowired
    private ThumbnailRepository thumbnailRepository;

    @Autowired
    private ListContentRepository listContentRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private ListTypeRepository listTypeRepository;

    @Override
    public CharacterDataWrapper findAll(Integer limit, Integer page_number, Long character_id){
        Pageable page = PageRequest.of(page_number, limit);

        List<CharacterRequest> characterRequestsList = new ArrayList<>();


        ListType comics_type = this.listTypeRepository.findOneByName("comics");
        ListType series_type = this.listTypeRepository.findOneByName("series");
        ListType stories_type = this.listTypeRepository.findOneByName("stories");
        ListType events_type = this.listTypeRepository.findOneByName("events");

        Page<Characteres> all = (-1 == character_id) ?
                this.characteresRepository.findAll(page) :
                this.characteresRepository.findAllById(character_id, page);

        all.forEach( characteres -> {

            ThumbnailRequest thumbnail = Thumbnail.toThumbnailRequest(
                    this.thumbnailRepository.findByCharacterId(characteres.getId()));

            List<UrlRequest> urls = Url.toUrlRequest_List(
                    this.urlRepository.findAllByCharacterId(characteres.getId())
            );

            ListContentRequest listContentRequest_comics = extract_listContent(comics_type, characteres);
            ListContentRequest listContentRequest_stories = extract_listContent(stories_type, characteres);
            ListContentRequest listContentRequest_series = extract_listContent(series_type, characteres);
            ListContentRequest listContentRequest_events = extract_listContent(events_type, characteres);

            characterRequestsList.add(
                    new CharacterRequest(
                        characteres.getId(),
                        characteres.getName(),
                        characteres.getDescription(),
                        characteres.getModified(),
                        thumbnail,
                        characteres.getResourceURI(),
                        listContentRequest_comics, //comics ListType
                        listContentRequest_stories, //series
                        listContentRequest_series, //stories
                        listContentRequest_events, //events,
                        urls
                    )
            );
        });

        CharacterDataContainer cdc = new CharacterDataContainer(
            page_number,
            limit,
            this.characteresRepository.count(),
            all.getTotalElements(),
            characterRequestsList
        );

        return new CharacterDataWrapper(
                200,
                "Ok",
                "© 2021 MARVEL",
                "Data provided by Marvel. © 2021 MARVEL",
                "<a href=\\\"http://marvel.com\\\">Data provided by Marvel. © 2021 MARVEL</a>",
                cdc,
                "etag"
        );
    }



    private ListContentRequest extract_listContent(ListType events_type, Characteres characteres) {
        ListContent listContent = this.listContentRepository.
                findOneByCharacterIdAndListTypeId(characteres.getId(), events_type.getId());
        List<ItemRequest> events_item = ItemRequest.toItemRequest_list(this.itemRepository.
                findAllByListContentId(listContent.getId()));


        return new ListContentRequest(
                listContent.getAvailable(),
                listContent.getCollectionURI(),
                events_item,
                listContent.getReturned()
        );
    }
}
