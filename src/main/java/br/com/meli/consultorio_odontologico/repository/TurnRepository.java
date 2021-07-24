package br.com.meli.consultorio_odontologico.repository;

import br.com.meli.consultorio_odontologico.entity.Turn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnRepository extends MongoRepository<Turn, String> {

    List<Turn> findByDiary_Dentist_Name(@Param(value = "name") String name);

    List<Turn> findByTurnStatus_Name(@Param(value = "name") String name);

}
