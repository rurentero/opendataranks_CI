package io.swagger.repository;

import io.swagger.model.Reuse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReuseRepository extends JpaRepository<Reuse, String> {
    // Already available:   findAll()
    //                      findById()
    Page<Reuse> findByTitleContainingIgnoreCase (String title, Pageable pageable);
    Page<Reuse> findByOrganizationTitleContainingIgnoreCase(String organizationTitle, Pageable pageable);
    Page<Reuse> findDistinctByTagsNameIgnoreCaseIn(List<String> name, Pageable pageable); //Containing Any Of given tags
}
