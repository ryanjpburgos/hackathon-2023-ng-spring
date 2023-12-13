package com.entando.example.springms.record;

import com.entando.example.springms.entity.TemplateEntity;

public record FormRecord(Long id, TemplateEntity template, String data, String userid) {

}
