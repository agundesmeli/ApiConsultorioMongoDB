package br.com.meli.consultorio_odontologico.repository;

import br.com.meli.consultorio_odontologico.entity.Dentist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends MongoRepository<Dentist, String> {
}