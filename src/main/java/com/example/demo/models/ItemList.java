package com.example.demo.models;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class ItemList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    Item item;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id")
    ListContent listContent;

    Date deletedAt;

    public ItemList() {
    }

    public ItemList(Item item, ListContent listContent) {
        this.item = item;
        this.listContent = listContent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ListContent getListContent() {
        return listContent;
    }

    public void setListContent(ListContent listContent) {
        this.listContent = listContent;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemList itemList = (ItemList) o;
        return Objects.equal(id, itemList.id) && Objects.equal(item, itemList.item) && Objects.equal(listContent, itemList.listContent) && Objects.equal(deletedAt, itemList.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, item, listContent, deletedAt);
    }
}
