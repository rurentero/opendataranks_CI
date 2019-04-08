package io.swagger.repository;

import io.swagger.model.Weight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightRepository extends JpaRepository<Weight, String> {
    //Already available:    -findAll()
}
