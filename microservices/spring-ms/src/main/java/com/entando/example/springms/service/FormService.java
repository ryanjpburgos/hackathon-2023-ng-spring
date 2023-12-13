package com.entando.example.springms.service;

import com.entando.example.springms.record.FormRecord;
import java.util.List;
import java.util.Optional;

public interface FormService {

    Optional<FormRecord> getForm(Long id);

    FormRecord save(FormRecord form);

    boolean exists(Long id);

    List<FormRecord> getAllForms();

    FormRecord update(FormRecord contactRecord);
}
