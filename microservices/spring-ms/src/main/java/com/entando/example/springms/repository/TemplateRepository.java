package com.entando.example.springms.repository;

import com.entando.example.springms.entity.TemplateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface TemplateRepository extends CrudRepository<TemplateEntity, UUID>, PagingAndSortingRepository<TemplateEntity, UUID> {

    Optional<TemplateEntity> findOneById(Long id);

    boolean existsById(Long id);

}
