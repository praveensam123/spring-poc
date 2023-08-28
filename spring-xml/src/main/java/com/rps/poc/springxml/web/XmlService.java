package com.rps.poc.springxml.web;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

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

    @SneakyThrows
    public Subject modifyXml(MultipartFile multipartFile) {
        File file = multipartFile.getResource().getFile();
        JAXBContext jaxbContext = JAXBContext.newInstance(Subject.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Subject subject = (Subject) unmarshaller.unmarshal(file);
        return modifyXml(subject);
    }
}
