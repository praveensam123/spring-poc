package com.rps.poc.springxml.web;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@ToString
@Builder
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Subject {

    private Integer id;
    private String name;
    private String description;

}
