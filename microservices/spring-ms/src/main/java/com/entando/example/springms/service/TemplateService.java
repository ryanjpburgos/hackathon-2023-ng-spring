package com.entando.example.springms.service;


import com.entando.example.springms.record.TemplateRecord;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TemplateService {


    Optional<TemplateRecord> getTemplate(Long id);

    TemplateRecord save(TemplateRecord template);

    TemplateRecord update(TemplateRecord contactRecord);

    Page<TemplateRecord> getAllTemplates(Pageable pageable);

    List<TemplateRecord> getAllTemplates();

    boolean exists(Long id);
}
