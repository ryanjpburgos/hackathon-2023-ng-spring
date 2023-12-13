package com.entando.example.springms.controller;

import com.entando.example.springms.record.FormRecord;
import com.entando.example.springms.record.TemplateRecord;
import com.entando.example.springms.service.FormService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/api/forms")
public class FormController {

    @Autowired
    private FormService service;

    private final Logger log = LoggerFactory.getLogger(FormController.class);


    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<FormRecord> getForm(@PathVariable Long id) {
        log.debug("REST request to get the template with id {}", id);

        return service
                .getForm(id)
                .map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<FormRecord> createForm(@RequestBody FormRecord template) throws URISyntaxException {
        log.debug("REST request to create a NEW form: {}", template );

        FormRecord created = service.save(template);
        return ResponseEntity
                .created(new URI("/api/contacts/" + created.id()))
                .body(created);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<FormRecord>> getAllForms() {
        log.debug("REST request to get all Forms");

        final List<FormRecord> templates = service.getAllForms();
        return ResponseEntity.ok().body(templates);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<FormRecord> updatForms(@PathVariable(value = "id") final Long id, @RequestBody FormRecord contact) {
        log.debug("REST request to update a form: {}", id);

        if (id == null || !Objects.equals(id, contact.id())) {
            return ResponseEntity.badRequest().build();
        }
        if (!service.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        FormRecord savedContact = service.update(contact);

        return ResponseEntity.ok().body(savedContact);
    }

}
