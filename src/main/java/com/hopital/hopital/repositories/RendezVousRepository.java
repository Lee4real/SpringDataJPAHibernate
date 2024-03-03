package com.hopital.hopital.repositories;

import com.hopital.hopital.entities.Patient;
import com.hopital.hopital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {

}
