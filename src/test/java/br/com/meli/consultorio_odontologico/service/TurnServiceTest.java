package br.com.meli.consultorio_odontologico.service;

import br.com.meli.consultorio_odontologico.entity.Dentist;
import br.com.meli.consultorio_odontologico.entity.Patient;
import br.com.meli.consultorio_odontologico.entity.Turn;
import br.com.meli.consultorio_odontologico.entity.TurnStatusEnum;
import br.com.meli.consultorio_odontologico.repository.DentistRepository;
import br.com.meli.consultorio_odontologico.repository.PatientRepository;
import br.com.meli.consultorio_odontologico.repository.TurnRepository;
import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TurnServiceTest {

    private DentistRepository dentistRepository;
    private PatientRepository patientRepository;
    private TurnRepository turnRepository;
    private TurnService turnService;
    private Dentist dentistMock;
    private Patient patientMock;
    private Turn turnMock;


    @BeforeEach
    public void init() {
        this.dentistRepository = Mockito.mock(DentistRepository.class);
        this.patientRepository = Mockito.mock(PatientRepository.class);
        this.turnRepository = Mockito.mock(TurnRepository.class);
        this.turnService = new TurnService(this.turnRepository, this.dentistRepository, this.patientRepository);
        this.dentistMock = new Dentist("Rafael", "Cardoso", "Dantista");
        this.patientMock = new Patient("Amanda", "Almeida", 27, "Feminino");
        this.turnMock = new Turn(LocalDate.of(2021, Month.JULY, 30), TurnStatusEnum.CONCLUIDO, this.patientMock, this.dentistMock);
    }

    @Test
    public void shouldReturnAnInstanceOfTurnService() {
        TurnService turnService = new TurnService();
        Assertions.assertNotNull(turnService);
    }

    @Test
    public void shouldSaveATurn() {
        //Arrange
        Mockito.when(this.turnRepository.insert(this.turnMock)).thenReturn(this.turnMock);

        //Act
        this.turnService.addTurn(this.turnMock);

        //Assert
        Mockito.verify(this.turnRepository).insert(this.turnMock);

    }

    @Test
    public void shouldReturnAListOfTurns() {
        //Arrange
        List<Turn> expectedTurnList = Arrays.asList(this.turnMock);
        Mockito.when(this.turnRepository.findAll()).thenReturn(expectedTurnList);

        //Act
        List<Turn> responseTurnList = this.turnService.getAllTurns();

        //Assert
        assertThat(responseTurnList).usingRecursiveComparison().isEqualTo(expectedTurnList);
    }

    @Test
    public void shouldReturnTurnsOfADentist() {
        //Arrange
        List<Turn> expectedTurnList = Arrays.asList(this.turnMock);
        Mockito.when(this.turnRepository.findTurnsByDentist_FirstName("Rafael")).thenReturn(expectedTurnList);

        //Act
        List<Turn> responseTurnList = this.turnService.getDentistTurns("Rafael");

        //Assert
        assertThat(responseTurnList).usingRecursiveComparison().isEqualTo(expectedTurnList);
    }


    @Test
    public void shouldReturnTurnWithAStatus() {
        //Arrange
        List<Turn> expectedTurnList = Arrays.asList(this.turnMock);
        Mockito.when(this.turnRepository.findTurnsByStatusIs("CONCLUIDO")).thenReturn(expectedTurnList);

        //Act
        List<Turn> responseTurnList = this.turnService.getTurnsByStatus("CONCLUIDO");

        //Assert
        assertThat(responseTurnList).usingRecursiveComparison().isEqualTo(expectedTurnList);
    }



}
