package br.com.meli.consultorio_odontologico.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.time.LocalDate;

@Document(collection = "turns")
@Data
@NoArgsConstructor
public class Turn {

    private String _id;

    private LocalDate day;

    @Enumerated(EnumType.STRING)
    private TurnStatusEnum status;

    private Patient patient;

    private Dentist dentist;

    public Turn(LocalDate day, TurnStatusEnum status, Patient patient, Dentist dentist) {
        this._id = this.get_id();
        this.day = day;
        this.status = status;
        this.patient = patient;
        this.dentist = dentist;
    }
}
