package io.swagger.helpers;

import io.swagger.model.Dataset;
import io.swagger.model.Reuse;
import io.swagger.model.Weight;
import io.swagger.repository.DatasetRepository;
import io.swagger.repository.ReuseRepository;
import io.swagger.repository.WeightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class RankingCalculator {

    private static final Logger log = LoggerFactory.getLogger(RankingCalculator.class);

    @Autowired
    private EntityManagerFactory entityManagerFactory; //Hibernate

    @Autowired private ReuseRepository reuseRepository;
    @Autowired private WeightRepository weightRepository;
    @Autowired private DatasetRepository datasetRepository;


    /**
     * Check every Weight and Reuse and calculate its ranking value. Then, this relation is persisted into the database.
     */
    public void calculateReuseRankings() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Retrieve all weights and reuses
        List<Weight> weights = weightRepository.findAll();
        List<Reuse> reuses = reuseRepository.findAll();

        Float calc;

        for (Weight weight : weights) {
            // One transaction per weight
            log.info("ReuseRankingCalculator", "Calculating all reuses ranking for weight " + weight.getId());
            entityManager.getTransaction().begin();
            for (Reuse reuse : reuses) {
                calc = (weight.getReviewsNumVal() * reuse.getReviewsNum()) +
                        (weight.getScoreVal() * reuse.getScore()) +
                        (weight.getDownloadsVal() * reuse.getDownloads());
                entityManager.createNativeQuery("INSERT INTO `reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('"+ calc + "','" + weight.getId() + "','" + reuse.getId() + "')").executeUpdate();
            } // End reuses block
            //Commit transaction
            entityManager.getTransaction().commit();
        } // End weights block
        entityManager.close();
        log.info("ReuseRankingCalculator:  Finished successfully");
    }

    /**
     * Check every Weight and Dataset and calculate its ranking value. Then, this relation is persisted into the database.
     */
    public void calculateDatasetsRankings(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Dataset> datasets = datasetRepository.findAll();
        List<Weight> weights = weightRepository.findAll();
        Float calc;
        log.info("DatasetRankingCalculator. Dataset calc start.");

        //Start transaction
        entityManager.getTransaction().begin();
        for (Dataset dataset : datasets) {
            List<Reuse> datReuses = dataset.getReuses();
            log.info("DatasetRankingCalculator. Calculating Dataset " + dataset.getId());

            for (Weight weight : weights){
                calc = 0f;
                //For every weight, find reuse ranking
                for (Reuse reuse : datReuses) {
                    Object row = entityManager.createNativeQuery("SELECT `value` FROM `reuse_weight` WHERE `weight_id`='" + weight.getId() + "' AND `reuse_id`='" + reuse.getId() + "'").getSingleResult();
                    calc = calc + (Float) row;
                }
                log.info("DatasetRankingCalculator. Ranking result for Weight "+ weight.getId() + ": " + calc );

                // Once all ranking values are added to calc, insert Dataset-Weight tuple
                entityManager.createNativeQuery("INSERT INTO `dataset_weight` (`value`, `weight_id`, `dataset_id`) VALUES ('" + calc + "','" + weight.getId() + "','" + dataset.getId() + "')").executeUpdate();
            }
        }
        //Commit transaction
        entityManager.getTransaction().commit();
        log.info("DatasetRankingCalculator. Dataset calc finished.");
    }

    /**
     * Calculate reuses ranking when for a given weight
     * @param weight Weight
     */
    public void calculateReusesRankingsFromWeight(Weight weight) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Retrieve all reuses
        List<Reuse> reuses = reuseRepository.findAll();

        Float calc;

        log.info("ReuseRankingCalculator", "Calculating all reuses ranking for given weight " + weight.getId());
        entityManager.getTransaction().begin();
        for (Reuse reuse : reuses) {
            calc = (weight.getReviewsNumVal() * reuse.getReviewsNum()) +
                    (weight.getScoreVal() * reuse.getScore()) +
                    (weight.getDownloadsVal() * reuse.getDownloads());
            entityManager.createNativeQuery("INSERT INTO `reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('" + calc + "','" + weight.getId() + "','" + reuse.getId() + "')").executeUpdate();
        } // End reuses block

        //Commit transaction
        entityManager.getTransaction().commit();
        entityManager.close();
        log.info("ReuseRankingCalculator:  Finished successfully");
    }

    /**
     * Calculate reuses ranking when for a given weight
     * @param weight Weight
     */
    public void calculateDatasetsRankingsFromWeight(Weight weight) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Retrieve all datasets
        List<Dataset> datasets = datasetRepository.findAll();

        Float calc;
        log.info("DatasetRankingCalculator. Dataset calc start.");

        //Start transaction
        entityManager.getTransaction().begin();
        for (Dataset dataset : datasets) {
            List<Reuse> datReuses = dataset.getReuses();
            log.info("DatasetRankingCalculator. Calculating Dataset " + dataset.getId());

            calc = 0f;
            //For every weight (one in this case), find reuse ranking
            for (Reuse reuse : datReuses) {
                Object row = entityManager.createNativeQuery("SELECT `value` FROM `reuse_weight` WHERE `weight_id`='" + weight.getId() + "' AND `reuse_id`='" + reuse.getId() + "'").getSingleResult();
                calc = calc + (Float) row;
            }
            log.info("DatasetRankingCalculator. Ranking result for Weight "+ weight.getId() + ": " + calc );

            // Once all ranking values are added to calc, insert Dataset-Weight tuple
            entityManager.createNativeQuery("INSERT INTO `dataset_weight` (`value`, `weight_id`, `dataset_id`) VALUES ('" + calc + "','" + weight.getId() + "','" + dataset.getId() + "')").executeUpdate();

        }
        //Commit transaction
        entityManager.getTransaction().commit();
        log.info("DatasetRankingCalculator. Dataset calc finished.");
    }
}
