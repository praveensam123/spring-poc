package com.rps.poc.springxml.web;

import org.springframework.stereotype.Service;

@Service
public class XmlService {

    public Subject produceXml() {
        return Subject.builder()
                .id(1)
                .name("maths")
                .description("Mathematics")
                .build();
    }

    public Subject modifyXml(Subject subject) {
        return Subject.builder()
                .id(subject.getId())
                .name("math")
                .description(subject.getDescription())
                .build();
    }
}
