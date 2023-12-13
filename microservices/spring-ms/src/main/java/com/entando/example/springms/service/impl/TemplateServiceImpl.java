package com.entando.example.springms.service.impl;


import com.entando.example.springms.entity.TemplateEntity;
import com.entando.example.springms.record.TemplateRecord;
import com.entando.example.springms.repository.TemplateRepository;
import com.entando.example.springms.service.TemplateService;
import com.entando.example.springms.service.mapper.TemplateMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TemplateServiceImpl implements TemplateService {

    private final TemplateRepository repository;

    private final TemplateMapper templateMapper;

    public TemplateServiceImpl(TemplateRepository repository, TemplateMapper templateMapper) {
        this.repository = repository;
        this.templateMapper = templateMapper;
    }

    @Override
    public Optional<TemplateRecord> getTemplate(Long id) {
        return repository.findOneById(id).map(templateMapper::toRecord);
    }

    @Override
    public TemplateRecord save(TemplateRecord template) {
        TemplateEntity entity = templateMapper.toEntity(template);
        TemplateEntity saved = repository.save(entity);
        return templateMapper.toRecord(saved);
    }

    @Override
    public TemplateRecord update(TemplateRecord contactRecord) {
        TemplateEntity contact = templateMapper.toEntity(contactRecord);
        repository.save(contact);

        return templateMapper.toRecord(contact);
    }

    @Override
    public Page<TemplateRecord> getAllContacts(Pageable pageable) {
        return repository.findAll(pageable).map(templateMapper::toRecord);
    }

    @Override
    public boolean exists(Long id) {
        return repository.existsById(id);
    }

}
