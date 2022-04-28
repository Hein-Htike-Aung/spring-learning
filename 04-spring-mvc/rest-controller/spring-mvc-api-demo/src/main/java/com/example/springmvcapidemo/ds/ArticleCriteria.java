package com.example.springmvcapidemo.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ArticleCriteria {

    private String bodyLike;

    public ArticleCriteria() {
    }
}
