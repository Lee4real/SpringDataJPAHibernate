package com.hopital.hopital;

import com.hopital.hopital.entities.*;
import com.hopital.hopital.repositories.ConsultationRepository;
import com.hopital.hopital.repositories.MedecinRepository;
import com.hopital.hopital.repositories.PatientRepository;
import com.hopital.hopital.repositories.RendezVousRepository;
import com.hopital.hopital.service.IHopitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HopitalApplication {

    public static void main(String[] args)  {
        SpringApplication.run(HopitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHopitalService iHopitalService, PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {

        return args -> {
            Stream.of("Mohammed", "Salah", "Oussama").forEach(nom -> {
                Patient patient = new Patient();
                patient.setNom(nom);
                patient.setDateNaissance(new Date());
                patient.setMalade(Math.random() > 0.5);
                patient.setScore((int) (Math.random() * 100));
                iHopitalService.savePatient(patient);
            });
            Stream.of("Khalid", "Hassan", "Omar").forEach(nom -> {
                Medecin medecin = new Medecin();
                medecin.setNom("Dr. "+nom);
                medecin.setEmail(nom+"@gmail.com");
                medecin.setSpecialite(Math.random()>0.5?"Cardiologue":"Dentiste");
                iHopitalService.saveMedecin(medecin);
            });
            Patient patient =  patientRepository.findById(1L).orElse(null);
            Patient patient1 =  patientRepository.findByNom("Salah");
            Medecin medecin = medecinRepository.findByNom("Dr. Khalid");
            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);

            iHopitalService.saveRendezVous(rendezVous);

            RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("RAS");
            iHopitalService.saveConsultation(consultation);
        };
    }

}
