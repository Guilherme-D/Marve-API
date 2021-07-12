package com.example.demo.dto;

import com.google.common.base.Objects;

public class CharacterDataWrapper {
    Integer code;
    String status;
    String copyright;
    String attributionText;
    String attributionHTML;
    CharacterDataContainer data;
    String etag;

    public CharacterDataWrapper() {
    }

    public CharacterDataWrapper(Integer code, String status, String copyright, String attributionText, String attributionHTML, CharacterDataContainer data, String etag) {
        this.code = code;
        this.status = status;
        this.copyright = copyright;
        this.attributionText = attributionText;
        this.attributionHTML = attributionHTML;
        this.data = data;
        this.etag = etag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public CharacterDataContainer getData() {
        return data;
    }

    public void setData(CharacterDataContainer data) {
        this.data = data;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterDataWrapper that = (CharacterDataWrapper) o;
        return Objects.equal(code, that.code) && Objects.equal(status, that.status) && Objects.equal(copyright, that.copyright) && Objects.equal(attributionText, that.attributionText) && Objects.equal(attributionHTML, that.attributionHTML) && Objects.equal(data, that.data) && Objects.equal(etag, that.etag);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code, status, copyright, attributionText, attributionHTML, data, etag);
    }
}

