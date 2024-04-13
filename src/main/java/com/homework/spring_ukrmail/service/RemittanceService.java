package com.homework.spring_ukrmail.service;

import com.homework.spring_ukrmail.models.Remittance;
import com.homework.spring_ukrmail.repo.MailRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class RemittanceService {


    private MailRepo repo;

    @Transactional
    public void addRem(Remittance remittance) {
        repo.save(remittance);
    }

    @Transactional
    public List<Remittance> findAll() {
        return repo.findAll();
    }

    @Transactional
    public void deleteRemi(Long id) {
        repo.deleteById(id);
    }

    @Transactional
    public void updateRemi(Remittance remittance) {

        repo.save(remittance);
    }
    @Transactional
    public Remittance getById(Long id) throws ChangeSetPersister.NotFoundException {
        return repo.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }


}
