package com.example.demo.models;

import com.example.demo.dto.ThumbnailRequest;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Thumbnail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    String path;
    String extension;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "characteres_id")
    Characteres character;

    LocalDateTime deletedAt;

    public Thumbnail() {
    }

    public Thumbnail(String path, String extension, Characteres characteres) {
        this.path = path;
        this.extension = extension;
        this.character = characteres;
    }

    public static ThumbnailRequest toThumbnailRequest(Thumbnail request) {
        return new ThumbnailRequest(
            request.getPath(),
            request.getExtension()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
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
        Thumbnail thumbnail = (Thumbnail) o;
        return Objects.equal(id, thumbnail.id) && Objects.equal(path, thumbnail.path) && Objects.equal(extension, thumbnail.extension) && Objects.equal(deletedAt, thumbnail.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, path, extension, deletedAt);
    }
}

