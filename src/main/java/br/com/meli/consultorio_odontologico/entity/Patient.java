package br.com.meli.consultorio_odontologico.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.time.LocalDate;

@Document(collection = "patients")
@Data
@NoArgsConstructor
public class Patient {

    @Id
    @Field(name = "id_patient")
    private Long patientId;

    private String name;

    @Field(name = "last_name")
    private String lastName;

    private String address;

    private String dni;

    @Field(name = "birth_date")
    private LocalDate birthDate;

    private String phone;

    private String email;

    public Patient(String name, String lastName, String address, String dni, LocalDate birthDate, String phone, String email) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.dni = dni;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
    }

}