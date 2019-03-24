package io.swagger.repository;

import io.swagger.model.Dataset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatasetRepository extends JpaRepository<Dataset, String> {
    // Already available:   findAll()
    //                      findById()
    List<Dataset> findByLicense (String license);
    List<Dataset> findByTitleContainingIgnoreCase (String title);
}
