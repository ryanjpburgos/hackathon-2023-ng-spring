package com.entando.example.springms.repository;

import com.entando.example.springms.entity.FormEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FormRepository extends CrudRepository<FormEntity, UUID>,
        PagingAndSortingRepository<FormEntity, UUID> {

    Optional<FormEntity> findOneById(Long id);

    boolean existsById(Long id);

}
