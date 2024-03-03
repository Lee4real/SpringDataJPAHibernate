package com.hopital.hopital.service;

import com.hopital.hopital.entities.Consultation;
import com.hopital.hopital.entities.Medecin;
import com.hopital.hopital.entities.Patient;
import com.hopital.hopital.entities.RendezVous;
import com.hopital.hopital.repositories.ConsultationRepository;
import com.hopital.hopital.repositories.MedecinRepository;
import com.hopital.hopital.repositories.PatientRepository;
import com.hopital.hopital.repositories.RendezVousRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class IHopitalServiceImpl implements IHopitalService {

    private PatientRepository patientRepository;
    private  MedecinRepository medecinRepository;
    private  RendezVousRepository rendezVousRepository;
    private  ConsultationRepository consultationRepository;



    @Override
    public Patient savePatient(Patient p) {
        return patientRepository.save(p);
    }

    @Override
    public Medecin saveMedecin(Medecin m) {
        return medecinRepository.save(m);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rv) {
        // pour generer des chaines de ch aléatoires et unique
        rv.setId(Long.valueOf(UUID.randomUUID().toString()));
        return rendezVousRepository.save(rv);
    }

    @Override
    public Consultation saveConsultation(Consultation c) {
        return consultationRepository.save(c);
    }

    @Override
    public Patient findPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public RendezVous findRendezVousbyId(Long id) {
        return null ;
        //rendezVousRepository.findById(id).orElse(null);
    }

    @Override
    public Medecin findMedecinbyId(Long id) {
        return medecinRepository.findById(id).orElse(null);
    }


}

