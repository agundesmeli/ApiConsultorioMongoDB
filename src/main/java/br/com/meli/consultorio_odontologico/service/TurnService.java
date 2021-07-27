package br.com.meli.consultorio_odontologico.service;

import br.com.meli.consultorio_odontologico.entity.Turn;
import br.com.meli.consultorio_odontologico.repository.DentistRepository;
import br.com.meli.consultorio_odontologico.repository.PatientRepository;
import br.com.meli.consultorio_odontologico.repository.TurnRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class TurnService {

    private TurnRepository turnRepository;
    private DentistRepository dentistRepository;
    private PatientRepository patientRepository;

    @Autowired
    public TurnService(TurnRepository turnRepository, DentistRepository dentistRepository, PatientRepository patientRepository) {
        this.turnRepository = turnRepository;
        this.dentistRepository = dentistRepository;
        this.patientRepository = patientRepository;
    }

    public void addTurn(Turn turn) {
        this.dentistRepository.insert(turn.getDentist());
        this.patientRepository.insert(turn.getPatient());
        this.turnRepository.insert(turn);
    }

    public List<Turn> getAllTurns() {
        return this.turnRepository.findAll();
    }

    public List<Turn> getDentistTurns(String name) {
        return this.turnRepository.findTurnsByDentist_FirstName(name);
    }

    public List<Turn> getTurnsByStatus(String status) {
        return this.turnRepository.findTurnsByStatusIs(status);
    }

}
