package io.swagger.configuration.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Date;

@Component
public class LikesMonitor {
    private static final Logger log = LoggerFactory.getLogger(LikesMonitor.class);

    @Autowired
    private EntityManagerFactory entityManagerFactory; //Hibernate

    /**
     * Triggers an scheduled task everyday at 23:00 PM. Deletes old entries in "likes_per_user" table. Expiration time set to 24 hours.
     */
    @Scheduled(cron = "0 0 23 * * ?")
    public void deleteOldEntries() {
        log.info("Triggering scheduled task: Delete old entries for 'likes_per_user' table");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // Set expiration time to 24 hours (86400000 milliseconds
        Date date = new Date();
        long deadline = date.getTime() - 86400000;
        entityManager.createNativeQuery("DELETE FROM `opendataranks_db`.`likes_per_user` WHERE `datemilis` < " + deadline).executeUpdate();
        //DELETE
        //FROM likes_per_user
        //WHERE datemilis < 1562263315000;
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
