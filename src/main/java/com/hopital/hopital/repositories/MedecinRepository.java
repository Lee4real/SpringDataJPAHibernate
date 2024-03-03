package com.hopital.hopital.repositories;

import com.hopital.hopital.entities.Medecin;
import com.hopital.hopital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String nom);

}
