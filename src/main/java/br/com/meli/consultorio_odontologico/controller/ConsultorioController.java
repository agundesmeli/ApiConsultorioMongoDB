package br.com.meli.consultorio_odontologico.controller;

import br.com.meli.consultorio_odontologico.service.DentistService;
import br.com.meli.consultorio_odontologico.service.PatientService;
import br.com.meli.consultorio_odontologico.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/consultorio")
public class ConsultorioController {

    private PatientService patientService;
    private DentistService dentistService;
    private TurnService turnService;

    public ConsultorioController() {
    }

    @Autowired
    public ConsultorioController(PatientService patientService, DentistService dentistService, TurnService turnService) {
        this.patientService = patientService;
        this.dentistService = dentistService;
        this.turnService = turnService;
    }

    @GetMapping("/turns")
    public ResponseEntity<?> getAllTurns() {
        return ResponseEntity.ok().body(turnService.getAllTurns());
    }

    @GetMapping("/turns/dentist/{name}")
    public ResponseEntity<?> getAllTurnsWithDentist(@PathVariable String name) {
        return ResponseEntity.ok().body(turnService.getDentistTurns(name));
    }

    @GetMapping("/turns/status/{name}")
    public ResponseEntity<?> getAllTurnsWithStatus(@PathVariable String name) {
        return ResponseEntity.ok().body(turnService.getTurnsByState(name));
    }

}
