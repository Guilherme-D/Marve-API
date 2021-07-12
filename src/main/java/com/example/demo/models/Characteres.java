package com.example.demo.models;

import com.example.demo.dto.CharacterRequest;
import com.example.demo.dto.ListContentRequest;
import com.example.demo.dto.ThumbnailRequest;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Characteres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    String name;
    String description;
    String resourceURI;
    /*@OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id")
    ListContent listContent;
   /* @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "thumbnail_id")
    List<Url> thumb;
    /*@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "list_id")
    ListContent series;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "list_id")
    ListContent stories;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "list_id")
    ListContent events;*/

    Date modified;
    Date deletedAt;

    public Characteres() {
    }

    public Characteres(String name, String description, String resourceURI/*, ListContent listContent*/) {
        this.name = name;
        this.description = description;
        this.resourceURI = resourceURI;
        //this.listContent = listContent;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    /*public ListContent getListContent() {
        return listContent;
    }

    public void setListContent(ListContent listContent) {
        this.listContent = listContent;
    }*/

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public static Characteres toCharacter(CharacterRequest request){
        /*ThumbnailRequest thumbnail_request = request.getThumbnail();
        Thumbnail thumbnail = new Thumbnail(thumbnail_request.getPath(), thumbnail_request.getExtension());

        ListContentRequest comics_request = request.getComics();


        new Characteres(
                request.getName(),
                request.getDescription(),
                request.getResourceURI(),
                thumbnail,
                request.getComics(),
                request.getSeries(),
                request.getStories(),
                request.getEvents(),
                request.getModified()
        )*/
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Characteres that = (Characteres) o;
        return Objects.equal(id, that.id) && Objects.equal(name, that.name) && Objects.equal(description, that.description) && Objects.equal(resourceURI, that.resourceURI) && Objects.equal(modified, that.modified) && Objects.equal(deletedAt, that.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, description, resourceURI, modified, deletedAt);
    }
}