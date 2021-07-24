package br.com.meli.consultorio_odontologico.service;

import br.com.meli.consultorio_odontologico.entity.Turn;
import br.com.meli.consultorio_odontologico.repository.TurnRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@NoArgsConstructor
public class TurnService {

    private TurnRepository turnRepository;

    @Autowired
    public TurnService(TurnRepository turnRepository) {
        this.turnRepository = turnRepository;
    }

    public List<Turn> getAllTurns() {
        return turnRepository.findAll();
    }

    public List<Turn> getDentistTurns(String name) {
        return turnRepository.findByDiary_Dentist_Name(name);
    }

    public List<Turn> getTurnsByState(String name) {
        return turnRepository.findByTurnStatus_Name(name);
    }

}
