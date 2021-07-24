package br.com.meli.consultorio_odontologico.repository;

import br.com.meli.consultorio_odontologico.entity.Turn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnRepository extends MongoRepository<Turn, String> {

    @Query("{ 'name' : ?0 }")
    List<Turn> findByDiary_Dentist_Name(String name);

    @Query("{ 'name' : ?0 }")
    List<Turn> findByTurnStatus_Name(String name);

}
