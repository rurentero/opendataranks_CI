package io.swagger.repository;

import io.swagger.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization,String> {
    // Already available:   findAll()
    //                      findById()
    List<Organization> findByTitleContainingIgnoreCase (String title);

}
