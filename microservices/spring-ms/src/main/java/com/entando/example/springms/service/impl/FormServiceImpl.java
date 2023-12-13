package com.entando.example.springms.service.impl;

import com.entando.example.springms.entity.FormEntity;
import com.entando.example.springms.record.FormRecord;
import com.entando.example.springms.repository.FormRepository;
import com.entando.example.springms.service.FormService;
import com.entando.example.springms.service.mapper.FormMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class FormServiceImpl implements FormService {

    private final FormRepository formRepository;

    private final FormMapper formMapper;

    public FormServiceImpl(FormRepository formRepository, FormMapper formMapper) {
        this.formRepository = formRepository;
        this.formMapper = formMapper;
    }

    @Override
    public Optional<FormRecord> getForm(Long id) {
        return formRepository.findOneById(id).map(formMapper::toRecord);
    }

    @Override
    public FormRecord save(FormRecord form) {
        FormEntity entity = formMapper.toEntity(form);
        formRepository.save(entity);
        return formMapper.toRecord(entity);
    }

    @Override
    public boolean exists(Long id) {
        return formRepository.existsById(id);
    }

    @Override
    public List<FormRecord> getAllForms() {
        return formRepository.findAll()
                .stream()
                .map(f -> formMapper.toRecord(f))
                .collect(Collectors.toList());
    }

    @Override
    public FormRecord update(FormRecord contactRecord) {
        FormEntity form = formMapper.toEntity(contactRecord);
        formRepository.save(form);

        return formMapper.toRecord(form);
    }

}
