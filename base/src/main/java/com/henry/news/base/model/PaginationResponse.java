package com.henry.news.base.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class PaginationResponse<T> implements Serializable {

    private List<T> response;
    private int totalPages;
    private Long totalElements;

}
