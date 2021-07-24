package br.com.meli.consultorio_odontologico.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;

@Document(collection = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @Field(name = "id_user")
    private Long id;

    @Field(name = "user_name")
    private String name;

    private String password;

    @Field(name = "user_status")
    private Boolean status;

    public User(String name, String password, Boolean status) {
        this.name = name;
        this.password = password;
        this.status = status;
    }
}
