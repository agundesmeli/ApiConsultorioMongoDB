package br.com.meli.consultorio_odontologico.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.time.LocalDate;

@Document(collection = "turns")
@Data
@NoArgsConstructor
public class Turn {

    @Id
    @Field(name = "id_turn")
    private Long id;

    private LocalDate day;

    @DBRef
    private TurnStatus turnStatus;

    @DBRef
    private Diary diary;

    @DBRef
    private Patient patient;

    public Turn(LocalDate day, TurnStatus turnStatus, Diary diary, Patient patient) {
        this.day = day;
        this.turnStatus = turnStatus;
        this.diary = diary;
        this.patient = patient;
    }
}
