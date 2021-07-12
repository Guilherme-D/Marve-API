package com.example.demo.dto;

import com.google.common.base.Objects;

import java.util.List;

public class CharacterDataContainer {
    Integer offset;
    Integer limit;
    Long total;
    Long count;
    List<CharacterRequest> results;

    public CharacterDataContainer() {
    }

    public CharacterDataContainer(Integer offset, Integer limit, Long total, Long count, List<CharacterRequest> results) {
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.count = count;
        this.results = results;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<CharacterRequest> getResults() {
        return results;
    }

    public void setResults(List<CharacterRequest> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterDataContainer that = (CharacterDataContainer) o;
        return Objects.equal(offset, that.offset) && Objects.equal(limit, that.limit) && Objects.equal(total, that.total) && Objects.equal(count, that.count) && Objects.equal(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(offset, limit, total, count, results);
    }
}
