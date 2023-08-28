package com.rps.poc.springxml.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/xml", produces = "application/xml")
public class XmlController {

    private final XmlService xmlService;

    @Autowired
    public XmlController(XmlService xmlService) {
        this.xmlService = xmlService;
    }

    @GetMapping("/produce")
    public ResponseEntity<Subject> produceXml() {
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        return ResponseEntity.ok(xmlService.produceXml());
    }

    @PostMapping(path = "/consume", consumes = "application/xml")
    public ResponseEntity<Subject> consumeXml(@RequestBody Subject subject) {
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        return ResponseEntity.ok(xmlService.modifyXml(subject));
    }

    @PostMapping(path = "/consumeAsFile", consumes = "multipart/form-data")
    public ResponseEntity<Subject> consumeXmlFile(@RequestParam("file") MultipartFile file) {
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        return ResponseEntity.ok(xmlService.modifyXml(file));
    }
}
