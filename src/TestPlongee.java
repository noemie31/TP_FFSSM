package FFSSM;

import org.junit.jupiter.api.*;

import java.time.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlongee {

    Moniteur moniteur1,moniteur2;
    Club club;
    Plongee plongee;
    Plongeur plongeur1, plongeur2;

    @BeforeEach
    public void setUp() {
        club = new Club(moniteur1,"NOM1","PRENOM1","0458926744");

        plongeur1=new Plongeur("123","NOMP1","PRENOMP1","Castres","0564289157",LocalDate.of(1964,10,5),2,GroupeSanguin.BMOINS);
        plongeur1.ajouterLicence("12",LocalDate.of(2022,6,4),club);
        plongeur2=new Plongeur("2","NOMP2","PRENOMP2","Castres","0592289157",LocalDate.of(1963,10,5),2,GroupeSanguin.BMOINS);
        plongeur2.ajouterLicence("13",LocalDate.of(2022,7,8),club);

        moniteur1 = new Moniteur("25646","NOM","PRENOM","Castres","095026758341",LocalDate.of(1960,5,8), 1,GroupeSanguin.APLUS,2);
        moniteur2 = new Moniteur("25556","NOM2","PRENOM2","Castres","095026796341",LocalDate.of(1961,5,8), 1,GroupeSanguin.APLUS,2);
        plongee = new Plongee(new Site("Site1","Beau"),moniteur1,LocalDate.of(2022,1,1),100,1);
    }

    @Test
    public void testAjouterParticipant() {
        plongee.ajouteParticipant(plongeur1);
        plongee.ajouteParticipant(plongeur2);
        assertEquals(2,plongee.getPalanquee().size());
    }

    @Test
    public void testPlongeeEstConforme() {
        plongee.ajouteParticipant(plongeur2);
        assertFalse(plongee.estConforme());

        plongee.ajouteParticipant(plongeur1);
        assertFalse(plongee.estConforme());
    }

}
