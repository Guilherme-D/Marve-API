package com.example.demo.models;

import com.example.demo.dto.ItemRequest;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ItemType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    String name;

    LocalDateTime deletedAt;

    public ItemType() {
    }

    public ItemType(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemType listType = (ItemType) o;
        return Objects.equal(id, listType.id) && Objects.equal(name, listType.name) && Objects.equal(deletedAt, listType.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, deletedAt);
    }
}
