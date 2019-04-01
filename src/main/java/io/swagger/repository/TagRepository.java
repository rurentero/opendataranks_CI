package io.swagger.repository;

import io.swagger.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, String> {
    // Already available: -findAll()
}
