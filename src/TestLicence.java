package FFSSM;

import org.junit.jupiter.api.*;

import java.time.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestLicence {

    Moniteur moniteur;
    Club club;
    Plongeur plongueur;
    Licence licenceValide, licenceInvalide;

    @BeforeEach
    public void setUp() {
        moniteur = new Moniteur("25646","NOM","PRENOM","Castres","095026758341",LocalDate.of(1960,5,8), 1,GroupeSanguin.APLUS,2);
        club = new Club(moniteur,"NOM2","PRENOM2","0452613587");
        licenceValide= new Licence(plongueur,"12",LocalDate.of(2022,1,1),club);
        licenceInvalide= new Licence(plongueur,"12",LocalDate.of(2020,1,1),club);
    }


    @Test
    public void testEstValide() {
        assertFalse(licenceInvalide.estValide(LocalDate.of(2022,6,6)));
        assertTrue(licenceValide.estValide(LocalDate.of(2022,6,6)));
    }
}
