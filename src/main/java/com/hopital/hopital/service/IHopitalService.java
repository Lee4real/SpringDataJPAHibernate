package com.hopital.hopital.service;

import com.hopital.hopital.entities.Consultation;
import com.hopital.hopital.entities.Medecin;
import com.hopital.hopital.entities.Patient;
import com.hopital.hopital.entities.RendezVous;

public interface IHopitalService {

    Patient savePatient(Patient patient);

    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

    Patient findPatientById(Long id);
    RendezVous findRendezVousbyId(Long id);
    Medecin findMedecinbyId(Long id);
}
