package com.entando.example.springms.service;


import com.entando.example.springms.record.TemplateRecord;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TemplateService {


    Optional<TemplateRecord> getTemplate(Long id);

    TemplateRecord save(TemplateRecord template);

    TemplateRecord update(TemplateRecord contactRecord);

    Page<TemplateRecord> getAllTemplates(Pageable pageable);

    List<TemplateRecord> getAllTemplates();

    boolean exists(Long id);
}
