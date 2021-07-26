package br.com.meli.consultorio_odontologico.service;

import br.com.meli.consultorio_odontologico.entity.Turn;
import br.com.meli.consultorio_odontologico.repository.TurnRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return this.turnRepository.findAll();
    }

    public void addTurn(Turn turn) {
        this.turnRepository.insert(turn);
    }

    public List<Turn> getDentistTurns(String name) {
        return this.turnRepository.findAllByDiary_Dentist_Name(name);
    }

    public List<Turn> getTurnsByState(String name) {
        return this.turnRepository.findAllByTurnStatus_Name(name);
    }

}
