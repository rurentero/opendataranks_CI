package io.swagger.repository;

import io.swagger.model.Dataset;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatasetRepository extends JpaRepository<Dataset, String> {
    // Already available:   findAll()
    //                      findById()
    Page<Dataset> findByLicense (String license, Pageable pageable);
    Page<Dataset> findByTitleContainingIgnoreCase (String title, Pageable pageable);
    Page<Dataset> findByOrganizationTitleContainingIgnoreCase (String organizationTitle, Pageable pageable);
    Page<Dataset> findDistinctByTagsNameIgnoreCaseIn(List<String> name, Pageable pageable); //Containing Any Of given tags
}
