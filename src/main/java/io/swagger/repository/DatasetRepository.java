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
    Page<Dataset> findDistinctByTagsIdIgnoreCaseIn(List<String> name, Pageable pageable); //Containing Any Of given tags


    // Find all using ranking
    Page<Dataset> findByWeightAssocWeightIdOrderByWeightAssocValueDesc(String Id, Pageable pageable);
    Page<Dataset> findByWeightAssocWeightIdOrderByWeightAssocValueAsc(String Id, Pageable pageable);

    // Find by title using rankings
    Page<Dataset> findByTitleContainingIgnoreCaseAndWeightAssocWeightIdOrderByWeightAssocValueDesc(String title, String id, Pageable pageable);
    Page<Dataset> findByTitleContainingIgnoreCaseAndWeightAssocWeightIdOrderByWeightAssocValueAsc(String title, String id, Pageable pageable);

    // Find by license using rankings
    Page<Dataset> findByLicenseContainingIgnoreCaseAndWeightAssocWeightIdOrderByWeightAssocValueDesc(String title, String id, Pageable pageable);
    Page<Dataset> findByLicenseContainingIgnoreCaseAndWeightAssocWeightIdOrderByWeightAssocValueAsc(String title, String id, Pageable pageable);

    // Find by organization using rankings
    Page<Dataset> findByOrganizationTitleContainingIgnoreCaseAndWeightAssocWeightIdOrderByWeightAssocValueDesc(String organizationTitle, String id, Pageable pageable);
    Page<Dataset> findByOrganizationTitleContainingIgnoreCaseAndWeightAssocWeightIdOrderByWeightAssocValueAsc(String organizationTitle, String id, Pageable pageable);

    // Find by tags using rankings
    // We cant use Distinct with OrderBy if the attribute specified in OrderBy is not present in the SELECT clause. Duplicated should be removed later.
    Page<Dataset> findByTagsIdIgnoreCaseInAndWeightAssocWeightIdOrderByWeightAssocValueDesc(List<String> name, String id, Pageable pageable);
    Page<Dataset> findByTagsIdIgnoreCaseInAndWeightAssocWeightIdOrderByWeightAssocValueAsc(List<String> name, String id, Pageable pageable);


}
