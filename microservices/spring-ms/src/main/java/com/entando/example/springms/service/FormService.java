package com.entando.example.springms.service;

import com.entando.example.springms.record.FormRecord;
import java.util.Optional;

public interface FormService {

    Optional<FormRecord> getForm(Long id);
}
