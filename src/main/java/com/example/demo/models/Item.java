package com.example.demo.models;

import com.example.demo.dto.ItemRequest;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    String resourceURI;
    String name;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_type_id")
    ItemType type;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_content_id")
    ListContent listContent;

    Date deletedAt;

    public Item() {
    }

    public Item(String resourceURI, String name, ItemType type, ListContent listContent) {
        this.resourceURI = resourceURI;
        this.name = name;
        this.type = type;
        this.listContent = listContent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public ListContent getListContent() {
        return listContent;
    }

    public void setListContent(ListContent listContent) {
        this.listContent = listContent;
    }

    public static Item toItem(ItemRequest itemRequest, ItemType listType, ListContent listContent){
        return new Item(itemRequest.getResourceURI(), itemRequest.getName(), listType, listContent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equal(id, item.id) && Objects.equal(resourceURI, item.resourceURI) && Objects.equal(name, item.name) && Objects.equal(type, item.type) && Objects.equal(deletedAt, item.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, resourceURI, name, type, deletedAt);
    }
}
