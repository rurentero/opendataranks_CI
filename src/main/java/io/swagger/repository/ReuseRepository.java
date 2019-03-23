package io.swagger.repository;

import io.swagger.model.Reuse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReuseRepository extends JpaRepository<Reuse, Long> {
    // TODO Metodos
    // Already available: findAll()
    Reuse findById(String id);
    List<Reuse> findByTitleContainingIgnoreCase (String title);
}
