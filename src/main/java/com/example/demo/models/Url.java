package com.example.demo.models;

import com.example.demo.dto.UrlRequest;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    String type;
    String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "characteres_id")
    Characteres character;

    LocalDateTime deletedAt;

    public Url() {
    }

    public Url(String type, String url, Characteres character) {
        this.type = type;
        this.url = url;
        this.character = character;
    }

    public static List<UrlRequest> toUrlRequest_List(List<Url> url) {
        return url.stream().map(Url::toUrlRequest).collect(Collectors.toList());

    }

    public static UrlRequest toUrlRequest(Url url){
        return new UrlRequest(url.getType(), url.getUrl());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Characteres getCharacter() {
        return character;
    }

    public void setCharacter(Characteres character) {
        this.character = character;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Url url1 = (Url) o;
        return Objects.equal(id, url1.id) && Objects.equal(type, url1.type) && Objects.equal(url, url1.url) && Objects.equal(character, url1.character) && Objects.equal(deletedAt, url1.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, type, url, character, deletedAt);
    }
}
