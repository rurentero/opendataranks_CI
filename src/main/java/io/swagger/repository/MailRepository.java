package io.swagger.repository;

import io.swagger.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<Mail, Integer> {
    // Already available:   findAll()
}
