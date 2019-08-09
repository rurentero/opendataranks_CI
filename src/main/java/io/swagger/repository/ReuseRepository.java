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
    Page<Reuse> findDistinctByTagsIdIgnoreCaseIn(List<String> name, Pageable pageable); //Containing Any Of given tags

    // Methods to be used when collections use ranking (weights).

    // Find all using rankings
    Page<Reuse> findByWeightAssocWeightIdOrderByWeightAssocValueDesc(String Id, Pageable pageable);
    Page<Reuse> findByWeightAssocWeightIdOrderByWeightAssocValueAsc(String Id, Pageable pageable);

    // Find by title using rankings
    Page<Reuse> findByTitleContainingIgnoreCaseAndWeightAssocWeightIdOrderByWeightAssocValueDesc(String title, String id, Pageable pageable);
    Page<Reuse> findByTitleContainingIgnoreCaseAndWeightAssocWeightIdOrderByWeightAssocValueAsc(String title, String id, Pageable pageable);

    // Find by organization using rankings
    Page<Reuse> findByOrganizationTitleContainingIgnoreCaseAndWeightAssocWeightIdOrderByWeightAssocValueDesc(String organizationTitle, String id, Pageable pageable);
    Page<Reuse> findByOrganizationTitleContainingIgnoreCaseAndWeightAssocWeightIdOrderByWeightAssocValueAsc(String organizationTitle, String id, Pageable pageable);

    // Find by tags using rankings
    // We cant use Distinct with OrderBy if the attribute specified in OrderBy is not present in the SELECT clause. Duplicated should be removed later.
    Page<Reuse> findByTagsIdIgnoreCaseInAndWeightAssocWeightIdOrderByWeightAssocValueDesc(List<String> name, String id, Pageable pageable);
    Page<Reuse> findByTagsIdIgnoreCaseInAndWeightAssocWeightIdOrderByWeightAssocValueAsc(List<String> name, String id, Pageable pageable);

}
