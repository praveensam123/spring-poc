package com.rps.poc.springxml.web;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Subject {

    private Integer id;
    private String name;
    private String description;

}
