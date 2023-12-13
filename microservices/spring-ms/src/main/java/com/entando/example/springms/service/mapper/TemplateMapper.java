package com.entando.example.springms.service.mapper;

import com.entando.example.springms.entity.TemplateEntity;
import com.entando.example.springms.record.TemplateRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TemplateMapper {

    public TemplateEntity toEntity(TemplateRecord recordIn) {
        TemplateEntity entityOut = new TemplateEntity();
        BeanUtils.copyProperties(recordIn, entityOut);
        return entityOut;
    }

    public TemplateRecord toRecord(TemplateEntity entity) {
        return new TemplateRecord(entity.getId(),
                entity.getTemplate(),
                entity.getUserid());
    }

}
