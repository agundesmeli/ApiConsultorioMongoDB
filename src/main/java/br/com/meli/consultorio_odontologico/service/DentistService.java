package br.com.meli.consultorio_odontologico.service;

import br.com.meli.consultorio_odontologico.entity.Dentist;
import br.com.meli.consultorio_odontologico.entity.Diary;
import br.com.meli.consultorio_odontologico.repository.DentistRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@NoArgsConstructor
public class DentistService {

    private DentistRepository dentistRepository;

    @Autowired
    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }



}
