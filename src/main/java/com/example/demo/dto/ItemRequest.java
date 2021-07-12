package com.example.demo.dto;

import com.example.demo.models.Item;
import com.google.common.base.Objects;

import java.util.List;
import java.util.stream.Collectors;

public class ItemRequest {
    String resourceURI;
    String name;
    String type;

    public ItemRequest() {
    }

    public ItemRequest(String resourceURI, String name, String type) {
        this.resourceURI = resourceURI;
        this.name = name;
        this.type = type;
    }

    public static List<ItemRequest> toItemRequest_list(List<Item> items) {
        return items.stream().map(ItemRequest::toItemRequest).collect(Collectors.toList());
    }

    private static ItemRequest toItemRequest(Item item) {
        return new ItemRequest(
                item.getResourceURI(),
                item.getName(),
                item.getType().getName()
        );
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemRequest that = (ItemRequest) o;
        return Objects.equal(resourceURI, that.resourceURI) && Objects.equal(name, that.name) && Objects.equal(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(resourceURI, name, type);
    }
}
