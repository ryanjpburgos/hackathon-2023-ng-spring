package com.entando.example.springms.controller;

import com.entando.example.springms.record.TemplateRecord;
import com.entando.example.springms.service.TemplateService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/entando-forms")
public class TemplateController {

    @Autowired
    private TemplateService service;

    private final Logger log = LoggerFactory.getLogger(TemplateController.class);

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<TemplateRecord> getTemplate(@PathVariable Long id) {
        log.debug("REST request to get the template with id {}", id);

        return service
                .getTemplate(id)
                .map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<TemplateRecord> createTemplate(@RequestBody TemplateRecord template) throws URISyntaxException {
        log.debug("REST request to create a NEW template: {}", template );

        TemplateRecord created = service.save(template);
        return ResponseEntity
                .created(new URI("/api/contacts/" + created.id()))
                .body(created);
    }


    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<TemplateRecord> updateTemplate(@PathVariable(value = "id") final Long id, @RequestBody TemplateRecord contact) {
        log.debug("REST request to update template: {}", id);

        if (id == null || !Objects.equals(id, contact.id())) {
            return ResponseEntity.badRequest().build();
        }
        if (!service.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        TemplateRecord savedContact = service.update(contact);

        return ResponseEntity.ok().body(savedContact);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<TemplateRecord>> getAllTemplates() {
        log.debug("REST request to get all Templates");

        final List<TemplateRecord> templates = service.getAllTemplates();
        return ResponseEntity.ok().body(templates);
    }

}
