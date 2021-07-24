package br.com.meli.consultorio_odontologico.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;

@Document(collection = "turn_status")
@Data
@NoArgsConstructor
public class TurnStatus {

    @Id
    @Field(name = "id_turn_status")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TurnStatusEnum name;

    private String description;

    public TurnStatus(TurnStatusEnum name, String description) {
        this.name = name;
        this.description = description;
    }
}
