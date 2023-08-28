package com.rps.poc.springxml.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(xmlService.produceXml());
    }

    @PostMapping(path = "/consume", consumes = "application/xml")
    public ResponseEntity<Subject> consumeXml(@RequestBody Subject subject) {
        return ResponseEntity.ok(xmlService.modifyXml(subject));
    }
}
