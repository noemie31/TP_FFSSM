package FFSSM;

//import jdk.vm.ci.meta.Local;
import jdk.vm.ci.meta.Local;
import org.junit.jupiter.api.*;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class TestMoniteur {

    Moniteur moniteur1,moniteur2;
    Club club1,club2;
    List<Embauche> listeEmbauches = new ArrayList<Embauche>();

    @BeforeEach
    public void setUp() {
        moniteur1 = new Moniteur("25646","NOM","PRENOM","Castres","095026758341",LocalDate.of(1960,5,8), 1,GroupeSanguin.APLUS,2);
        moniteur2 = new Moniteur("25626","NOM2","PRENOM2","Castres","095566758341",LocalDate.of(1955,5,8), 1,GroupeSanguin.BMOINS,2);
        club1 = new Club(moniteur1,"NOMC1","PRENOMC1","0452613587");
        club2 = new Club(moniteur2,"NOMC2","PRENOMC2","0432619587");

    }

    @AfterEach
    public void tearDown() throws Exception {

    }

    @Test
    public void testNouvelleEmbauche() {
        listeEmbauches.add(new Embauche(LocalDate.of(2022,6,4),moniteur2,club1));
        assertFalse(listeEmbauches.isEmpty());
    }

    @Test
    public void testEmployerActuel(){
        moniteur1.nouvelleEmbauche(club1,LocalDate.of(2022,10,5));
        assertTrue(moniteur1.employeurActuel().isPresent());
    }

    
}
