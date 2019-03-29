package io.swagger.repository;

import io.swagger.model.Reuse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReuseRepository extends JpaRepository<Reuse, String> {
    // Already available:   findAll()
    //                      findById()
    List<Reuse> findByTitleContainingIgnoreCase (String title);
    List<Reuse> findByOrganizationTitleContainingIgnoreCase(String organizationTitle);
    List<Reuse> findDistinctByTagsNameIgnoreCaseIn(List<String> name); //Containing Any Of given tags
}
