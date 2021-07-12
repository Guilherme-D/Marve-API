package com.example.demo.repository;

import com.example.demo.models.ListContent;
import com.example.demo.models.ListType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListContentRepository extends JpaRepository<ListContent,Long> {

    List<ListContent> findAllByCharacterIdAndListTypeId(Long id, Long id1);

    ListContent findOneByCharacterIdAndListTypeId(Long id, Long id1);
    //List<ListContent> findAllByCharactereIdAndListTypeId(Long char_id, Long type_id);
}
