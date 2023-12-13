package com.entando.example.springms.repository;

import com.entando.example.springms.entity.TemplateEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TemplateRepository extends CrudRepository<TemplateEntity, UUID>, PagingAndSortingRepository<TemplateEntity, UUID> {

    Optional<TemplateEntity> findOneById(Long id);

    boolean existsById(Long id);

    List<TemplateEntity> findAll();

}
