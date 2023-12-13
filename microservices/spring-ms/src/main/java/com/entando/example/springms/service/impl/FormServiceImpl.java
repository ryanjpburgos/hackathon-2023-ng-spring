package com.entando.example.springms.service.impl;

import com.entando.example.springms.record.FormRecord;
import com.entando.example.springms.repository.FormRepository;
import com.entando.example.springms.service.FormService;
import com.entando.example.springms.service.mapper.FormMapper;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class FormServiceImpl implements FormService {

    private final FormRepository repository;

    private final FormMapper formMapper;

    public FormServiceImpl(FormRepository repository, FormMapper formMapper) {
        this.repository = repository;
        this.formMapper = formMapper;
    }

    @Override
    public Optional<FormRecord> getForm(Long id) {
        return repository.findOneById(id).map(formMapper::toRecord);
    }



}
