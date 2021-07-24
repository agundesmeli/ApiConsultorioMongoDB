package br.com.meli.consultorio_odontologico.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.time.LocalDateTime;

@Document(collection = "diarys")
@Data
@NoArgsConstructor
public class Diary {

    @Id
    @Field(name = "id_diary")
    private Long id;

    @Field(name = "start_time")
    private LocalDateTime startTime;

    @Field(name = "ending_time")
    private LocalDateTime endingTime;

    @DBRef
    private Dentist dentist;

    public Diary(LocalDateTime startTime, LocalDateTime endingTime, Dentist dentist) {
        this.startTime = startTime;
        this.endingTime = endingTime;
        this.dentist = dentist;
    }
}
