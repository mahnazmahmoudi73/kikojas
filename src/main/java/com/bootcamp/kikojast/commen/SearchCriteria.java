package com.bootcamp.kikojast.commen;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class SearchCriteria {

    private String key;
    private Object value;
    private  SearchOperation operation;

}