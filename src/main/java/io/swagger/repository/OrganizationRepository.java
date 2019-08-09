package io.swagger.repository;

import io.swagger.model.Organization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,String> {
    // Already available:   findAll()
    //                      findById()
    Page<Organization> findByTitleContainingIgnoreCase (String title, Pageable pageable);

}
