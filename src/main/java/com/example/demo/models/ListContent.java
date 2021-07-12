package com.example.demo.models;

import com.example.demo.dto.ListContentRequest;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class ListContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    Integer available;
    Integer returned;
    String collectionURI;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_type_id")
    ListType listType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "charactere_id")
    Characteres character;

    LocalDateTime deletedAt;

    public ListContent() {
    }

    public ListContent(Integer available, Integer returned, String collectionURI, ListType listType, Characteres characteres) {
        this.available = available;
        this.returned = returned;
        this.collectionURI = collectionURI;
        this.listType = listType;
        this.character = characteres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Integer getReturned() {
        return returned;
    }

    public void setReturned(Integer returned) {
        this.returned = returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public ListType getListType() {
        return listType;
    }

    public void setListType(ListType listType) {
        this.listType = listType;
    }

    public Characteres getCharacter() {
        return character;
    }

    public void setCharacter(Characteres character) {
        this.character = character;
    }

    public static ListContent toListContent (ListContentRequest listContentRequest, ListType listType, Characteres characteres){
        return new ListContent(listContentRequest.getAvailable(),
                listContentRequest.getReturned(),
                listContentRequest.getCollectionURI(),
                listType,
                characteres
                );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListContent that = (ListContent) o;
        return Objects.equal(id, that.id) && Objects.equal(available, that.available) && Objects.equal(returned, that.returned) && Objects.equal(collectionURI, that.collectionURI) && Objects.equal(listType, that.listType) && Objects.equal(character, that.character) && Objects.equal(deletedAt, that.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, available, returned, collectionURI, listType, character, deletedAt);
    }
}
