package com.homework.spring_ukrmail.repo;

import com.homework.spring_ukrmail.models.Remittance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepo extends JpaRepository <Remittance, Long> {
}
