package br.com.meli.consultorio_odontologico.service;

import br.com.meli.consultorio_odontologico.entity.Patient;
import br.com.meli.consultorio_odontologico.repository.PatientRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@NoArgsConstructor
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


}
