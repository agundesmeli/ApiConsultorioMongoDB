package br.com.meli.consultorio_odontologico.repository;

import br.com.meli.consultorio_odontologico.entity.Turn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnRepository extends MongoRepository<Turn, String> {

    List<Turn> findAllByDiary_Dentist_Name(String name);

    List<Turn> findAllByTurnStatus_Name(String name);

}
