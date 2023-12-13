package com.entando.example.springms.controller;

import com.entando.example.springms.record.TemplateRecord;
import com.entando.example.springms.service.TemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class TemplateController {

    @Autowired
    private TemplateService service;

    private final Logger log = LoggerFactory.getLogger(TemplateController.class);

    @CrossOrigin
    @GetMapping("/entando-forms/{id}")
    public ResponseEntity<TemplateRecord> getExample(@PathVariable Long id) {
        log.debug("REST request to get the template with id {}", id);

        return service
                .getTemplate(id)
                .map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/template")
    public ResponseEntity<TemplateRecord> createContact(@RequestBody TemplateRecord template) throws URISyntaxException {
        log.debug("REST request to create a NEW template: {}", template );

        TemplateRecord created = service.save(template);
        return ResponseEntity
                .created(new URI("/api/contacts/" + created.id()))
                .body(created);
    }


    @PutMapping("/entando-forms/{id}")
    public ResponseEntity<TemplateRecord> updateContact(@PathVariable(value = "id") final Long id, @RequestBody TemplateRecord contact) {
        log.debug("REST request to update template: {}", id);

        if(id == null || !Objects.equals(id, contact.id())) {
            return ResponseEntity.badRequest().build();
        }
        if(!service.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        TemplateRecord savedContact = service.update(contact);

        return ResponseEntity.ok().body(savedContact);
    }

}
