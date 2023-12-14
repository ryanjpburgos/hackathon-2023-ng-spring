package com.entando.example.springms.service.mapper;

import com.entando.example.springms.entity.FormEntity;
import com.entando.example.springms.record.FormRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class FormMapper {

    public FormEntity toEntity(FormRecord recordIn) {
        FormEntity entityOut = new FormEntity();
        BeanUtils.copyProperties(recordIn, entityOut);
        return entityOut;
    }

    public FormRecord toRecord(FormEntity entity) {
        return new FormRecord(entity.getId(),
                entity.getTemplateid().getId(),
                entity.getPayload(),
                entity.getUserid());
    }

}
