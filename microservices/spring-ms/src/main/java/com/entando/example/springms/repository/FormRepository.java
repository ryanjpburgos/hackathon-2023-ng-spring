package com.entando.example.springms.repository;

import com.entando.example.springms.entity.FormEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FormRepository extends CrudRepository<FormEntity, Long>,
        PagingAndSortingRepository<FormEntity, Long> {

    Optional<FormEntity> findOneById(Long id);

    boolean existsById(Long id);

    List<FormEntity> findAll();

}
