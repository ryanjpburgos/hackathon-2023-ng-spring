package com.entando.example.springms.repository;

import com.entando.example.springms.entity.TemplateEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TemplateRepository extends CrudRepository<TemplateEntity, Long>, PagingAndSortingRepository<TemplateEntity, Long> {

    Optional<TemplateEntity> findOneById(Long id);

    boolean existsById(Long id);

    List<TemplateEntity> findAll();

}
