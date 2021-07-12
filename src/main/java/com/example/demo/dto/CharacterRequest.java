package com.example.demo.dto;

import com.example.demo.models.Characteres;
import com.google.common.base.Objects;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class CharacterRequest {
    Long id;
    String name;
    String description;
    Date modified;
    ThumbnailRequest thumbnail;
    String resourceURI;
    ListContentRequest comics;
    ListContentRequest series;
    ListContentRequest stories;
    ListContentRequest events;
    List<UrlRequest> urls;

    public CharacterRequest() {
    }

    public CharacterRequest(Long id, String name, String description, Date modified,
                            ThumbnailRequest thumbnail, String resourceURI, ListContentRequest comics,
                            ListContentRequest series, ListContentRequest stories,
                            ListContentRequest events, List<UrlRequest> urls) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.modified = modified;
        this.thumbnail = thumbnail;
        this.resourceURI = resourceURI;
        this.comics = comics;
        this.series = series;
        this.stories = stories;
        this.events = events;
        this.urls = urls;
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

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public ThumbnailRequest getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ThumbnailRequest thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public ListContentRequest getComics() {
        return comics;
    }

    public void setComics(ListContentRequest comics) {
        this.comics = comics;
    }

    public ListContentRequest getSeries() {
        return series;
    }

    public void setSeries(ListContentRequest series) {
        this.series = series;
    }

    public ListContentRequest getStories() {
        return stories;
    }

    public void setStories(ListContentRequest stories) {
        this.stories = stories;
    }

    public ListContentRequest getEvents() {
        return events;
    }

    public void setEvents(ListContentRequest events) {
        this.events = events;
    }

    public List<UrlRequest> getUrls() {
        return urls;
    }

    public void setUrls(List<UrlRequest> urls) {
        this.urls = urls;
    }

    public static Characteres toCharacteres (CharacterRequest characterRequest){

        return null;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterRequest that = (CharacterRequest) o;
        return Objects.equal(id, that.id) && Objects.equal(name, that.name) && Objects.equal(description, that.description) && Objects.equal(modified, that.modified) && Objects.equal(thumbnail, that.thumbnail) && Objects.equal(resourceURI, that.resourceURI) && Objects.equal(comics, that.comics) && Objects.equal(series, that.series) && Objects.equal(stories, that.stories) && Objects.equal(events, that.events) && Objects.equal(urls, that.urls);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, description, modified, thumbnail, resourceURI, comics, series, stories, events, urls);
    }
}
