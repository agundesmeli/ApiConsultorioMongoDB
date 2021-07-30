package br.com.meli.consultorio_odontologico.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import br.com.meli.consultorio_odontologico.entity.Dentist;
import br.com.meli.consultorio_odontologico.entity.Patient;
import br.com.meli.consultorio_odontologico.entity.Turn;
import br.com.meli.consultorio_odontologico.entity.TurnStatusEnum;
import br.com.meli.consultorio_odontologico.repository.TurnRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.Month;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ConsultorioControllerTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private TurnRepository turnRepository;

    @BeforeEach
    public void init() {
        this.turnRepository.deleteAll();
    }

    @Test
    public void shouldSaveATurn() throws Exception {
        Turn turn = createTurn();
        String payload = objectMapper.writeValueAsString(turn);
        this.turnRepository.insert(turn);

        mock.perform(post("/consultorio/turn")
                .contentType("application/json")
                .content(payload))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldReturnAListOfAllTurns() throws Exception{
        this.turnRepository.insert(createTurn());

        mock.perform(get("/consultorio/turns"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$[0].day").value("2021-07-30"));
    }

    @Test
    public void shouldReturnAListOfADentistTurns() throws Exception{
        Turn turn = this.turnRepository.insert(createTurn());

        mock.perform(get("/consultorio/turns/dentist/{name}", turn.getDentist().getFirstName()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$[0].day").value("2021-07-30"));
    }

    @Test
    public void shouldReturnAListOfTurnsWithStatus() throws Exception{
        Turn turn = this.turnRepository.insert(createTurn());

        mock.perform(get("/consultorio/turns/status/{status}", turn.getStatus()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$[0].day").value("2021-07-30"));
    }

    private Turn createTurn() {
        Turn turn = new Turn(LocalDate.of(2021, Month.JULY, 30), TurnStatusEnum.CONCLUIDO, this.createPatient(), this.crateDentist());
        return turn;
    }

    private Dentist crateDentist() {
        Dentist dentist = new Dentist("Rafael", "Cardoso", "Dentista");
        return dentist;
    }

    private Patient createPatient() {
        Patient patient = new Patient("Amanda", "Almeida", 27, "Feminino");
        return patient;
    }
}
