package com.dchans.api.admin.dto.common;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageResponse<T> {
    private List<T> data;
    private int currentPage;
    private int totalPage;
    private long totalCount;
    private int pageSize;

    public PageResponse(List<T> data, int currentPage, int totalPage, long totalCount, int pageSize) {
        this.data = data;
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
    }
}