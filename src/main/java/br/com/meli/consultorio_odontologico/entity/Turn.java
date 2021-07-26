package br.com.meli.consultorio_odontologico.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
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
    private Long turnId;

    private LocalDate day;

    @Field(name = "turn_status")
    private TurnStatus turnStatus;

    private Diary diary;

    private Patient patient;

    public Turn(LocalDate day, TurnStatus turnStatus, Diary diary, Patient patient) {
        this.day = day;
        this.turnStatus = turnStatus;
        this.diary = diary;
        this.patient = patient;
    }
}
