package io.swagger.repository;

import io.swagger.model.Reuse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReuseRepository extends JpaRepository<Reuse, String> {
    // Already available:   findAll()
    //                      findById()
    Page<Reuse> findByTitleContainingIgnoreCase (String title, Pageable pageable);
    Page<Reuse> findByOrganizationTitleContainingIgnoreCase(String organizationTitle, Pageable pageable);
    Page<Reuse> findDistinctByTagsNameIgnoreCaseIn(List<String> name, Pageable pageable); //Containing Any Of given tags

    // Methods to be used when collections use ranking (weights).
    // TODO Metodos para el resto de colecciones
    Page<Reuse> findByWeightAssocWeightIdOrderByWeightAssocValueDesc(String Id, Pageable pageable);
    Page<Reuse> findByWeightAssocWeightIdOrderByWeightAssocValueAsc(String Id, Pageable pageable);

    // TODO Prueba con Query descartada
    @Query("select r, wa.value from Reuse r inner join r.weightAssoc wa where wa.weight=:Id")
    Page<Object> findCustom(String Id, Pageable pageable);






    //TODO Para que el JSON solo muestre un value, crear una query (respuesta de Atal?) Aqui: https://stackoverflow.com/questions/22007341/spring-jpa-selecting-specific-columns
}
