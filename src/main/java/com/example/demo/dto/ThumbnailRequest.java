package com.example.demo.dto;

import com.example.demo.models.Characteres;
import com.example.demo.models.Thumbnail;
import com.google.common.base.Objects;

public class ThumbnailRequest {
    String path;
    String extension;

    public ThumbnailRequest() {
    }

    public ThumbnailRequest(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    public static Thumbnail toThumbnail(ThumbnailRequest thumbnail_request, Characteres characteres) {
        return new Thumbnail(thumbnail_request.getPath(), thumbnail_request.getExtension(), characteres);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThumbnailRequest that = (ThumbnailRequest) o;
        return Objects.equal(path, that.path) && Objects.equal(extension, that.extension);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(path, extension);
    }
}
