package FFSSM;

import org.junit.jupiter.api.*;

import java.time.*;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TestClub {

    Moniteur moniteur1,moniteur2;
    Plongee plongee1,plongee2;
    Club cluba;
    Plongeur plongeura,plongeurb;
    private Set<Plongee> listeplongee = new HashSet<Plongee>();
    private Set<Licence> licencesdelivree = new HashSet<Licence>();

    @BeforeEach
    protected void setUp() throws Exception {
        moniteur1 = new Moniteur("25646","NOM","sdqds","Castres","095026758341",LocalDate.of(1960,5,8), 1,GroupeSanguin.APLUS,2);
        moniteur2 = new Moniteur("25626","NOM2","PRENdsqd","Castres","095566758341",LocalDate.of(1955,5,8), 1,GroupeSanguin.BMOINS,2);
        plongee1 = new Plongee(new Site("Site1","Beau"),moniteur1,LocalDate.of(2022,1,1),100,1);
        plongee2 = new Plongee(new Site("Site2","Beau"),moniteur1,LocalDate.of(2022,2,1),100,1);
        cluba = new Club(moniteur1,"dfsfs","fpdsfosdf","5489632710");
        plongeura=new Plongeur("123","NOMP1","PRENOMP1","Castres","0564289157",LocalDate.of(1964,10,5),2,GroupeSanguin.BMOINS);
        plongeurb=new Plongeur("3","NOMP2","PRENOM2","Castres","0569689157",LocalDate.of(1960,10,5),2,GroupeSanguin.BMOINS);
    }

    @Test
    public void testOrganisePlongee(){
        listeplongee.add(plongee1);
        listeplongee.add(plongee2);
        assertEquals(2,listeplongee.size());
    }

    @Test
    public void testDelivreLicence(){
        licencesdelivree.add(new Licence(plongeura,"1",LocalDate.of(2022,1,1),cluba));
        assertEquals(licencesdelivree.size(),1);
    }

    @Test
    public void testPlongeeNonConforme(){
        assertEquals(plongee1.estConforme(),false);
        //est plongée est pas conforme
    }
}
