package com.example.demo.dto;

import com.example.demo.models.ListContent;
import com.example.demo.models.Url;
import com.google.common.base.Objects;

import java.util.List;
import java.util.stream.Collectors;

public class ListContentRequest {
    Integer available;
    String collectionURI;
    List<ItemRequest> items;
    Integer returned;

    public ListContentRequest() {
    }

    public ListContentRequest(Integer available, String collectionURI, List<ItemRequest> items, Integer returned) {
        this.available = available;
        this.collectionURI = collectionURI;
        this.items = items;
        this.returned = returned;
    }

    public static List<ListContentRequest> toListContentRequest_list(List<ListContent> listContents, List<ItemRequest> items) {
        return listContents.stream().map(l -> ListContentRequest.toListContentRequest(l, items))
                .collect(Collectors.toList());
    }

    public static ListContentRequest toListContentRequest(ListContent listContent, List<ItemRequest> items){
        return new ListContentRequest(
                listContent.getAvailable(),
                listContent.getCollectionURI(),
                items,
                listContent.getReturned()
        );
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<ItemRequest> getItems() {
        return items;
    }

    public void setItems(List<ItemRequest> items) {
        this.items = items;
    }

    public Integer getReturned() {
        return returned;
    }

    public void setReturned(Integer returned) {
        this.returned = returned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListContentRequest that = (ListContentRequest) o;
        return Objects.equal(available, that.available) && Objects.equal(collectionURI, that.collectionURI) && Objects.equal(items, that.items) && Objects.equal(returned, that.returned);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(available, collectionURI, items, returned);
    }
}
