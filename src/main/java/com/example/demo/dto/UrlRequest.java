package com.example.demo.dto;

import com.example.demo.models.Characteres;
import com.example.demo.models.Url;
import com.google.common.base.Objects;

import java.util.List;
import java.util.stream.Collectors;

public class UrlRequest {
    String type;
    String url;

    public UrlRequest() {
    }

    public UrlRequest(String type, String url) {
        this.type = type;
        this.url = url;
    }

    public static List<Url> toURL_list(List<UrlRequest> urls, Characteres characteres) {
        return urls.stream().map( u -> UrlRequest.toUrl(u, characteres)).collect(Collectors.toList());
    }

    public static Url toUrl(UrlRequest url, Characteres character){
        return new Url(url.getType(), url.getUrl(), character);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrlRequest that = (UrlRequest) o;
        return Objects.equal(type, that.type) && Objects.equal(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(type, url);
    }
}
