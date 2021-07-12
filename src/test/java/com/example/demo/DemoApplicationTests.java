package com.example.demo;

import com.example.demo.dto.*;
import com.example.demo.models.*;
import com.example.demo.repository.*;
import com.example.demo.service.ItemService;
import com.example.demo.service.ItemTypeService;
import com.example.demo.service.ListTypeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private CharacteresRepository characteresRepository;
	@Autowired
	private ItemListRepository itemListRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private ListContentRepository listContentRepository;
	@Autowired
	private ItemTypeRepository itemTypeRepository;
	@Autowired
	private ThumbnailRepository thumbnailRepository;
	@Autowired
	private UrlRepository repository;
	@Autowired
	private ListTypeRepository listTypeRepository;
	@Autowired
	private UrlRepository urlRepository;


	@Autowired
	private ItemService itemService;
	@Autowired
	private ItemTypeService itemTypeService;
	@Autowired
	private ListTypeService listTypeService;


	@Test
	void contextLoads() {
		final ListType empty_type = this.listTypeService.findByName("");
		final ListType comics_type = this.listTypeService.findByName("comics");
		final ListType series_type = this.listTypeService.findByName("series");
		final ListType stories_type = this.listTypeService.findByName("stories");
		final ListType event_type = this.listTypeService.findByName("events");

		try {
			String strings = Files.readAllLines(Paths.get("/home/desenvolvedor/Desktop/458583/mais/teste/Marvel-API/src/test/java/com/example/demo/data.json")).stream().map(String::valueOf).collect(Collectors.joining());

			CharacterDataWrapper json_data = new ObjectMapper()
					.readValue(strings, CharacterDataWrapper.class);

			final List<CharacterRequest> results = json_data.getData().getResults();

			List<Characteres> characteres_to_save = new ArrayList<>();
			List<Url> urls_to_save = new ArrayList<>();
			List<Item> items_to_save = new ArrayList<>();

			//percorre personagens
			results.forEach(r -> {

				Characteres save_char = this.characteresRepository.save(
					new Characteres(
						r.getName(),
						r.getDescription(),
						r.getResourceURI()
					)
				);

				// salva todos os itens da lista de comics do json
				ListContent content_comics = extracted(comics_type, r, save_char, empty_type);
				items_to_save.addAll(extract_request(r.getComics(), content_comics));

				// salva todos os itens da lista de series do json
				ListContent content_series = extracted(series_type, r, save_char, empty_type);
				items_to_save.addAll(extract_request(r.getSeries(), content_series));
				
				// salva todos os itens da lista de events do json
				ListContent content_events = extracted(event_type, r, save_char, empty_type);
				items_to_save.addAll(extract_request(r.getEvents(), content_events));


				// salva todos os itens da lista de stories do json
				ListContent content_stories = extracted(stories_type, r, save_char, empty_type);
				items_to_save.addAll(extract_request(r.getStories(), content_stories));
				urls_to_save.addAll(UrlRequest.toURL_list(r.getUrls(), save_char));


				this.urlRepository.saveAll(UrlRequest.toURL_list(r.getUrls(), save_char));

				this.thumbnailRepository.save(ThumbnailRequest.toThumbnail(r.getThumbnail(), save_char));


			});
			this.itemRepository.saveAll(items_to_save);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private ListContent extracted(ListType type, CharacterRequest char_request, Characteres character, ListType empty_type) {
		ListType type_check = (null == type) ? empty_type : type;

		ListContentRequest comics_request = char_request.getComics();

		ListContent listContent = ListContent.toListContent(comics_request, type_check, character);

		this.urlRepository.saveAll(UrlRequest.toURL_list(char_request.getUrls(), character));

		return this.listContentRepository.save(listContent);
		//return extract_request(comics_request, listContent_comics);
	}

	private List<Item> extract_request(ListContentRequest request, ListContent listContent) {
		List<Item> request_to_return = new ArrayList<>();
		
		request.getItems().forEach(i -> {
			String type_name = (null == i.getType()) ? "" : i.getType();
			ItemType type = this.itemTypeService.create(new ItemType(type_name));
			request_to_return.add(Item.toItem(i, type, listContent));
		});
		
		return request_to_return;
	}

}
