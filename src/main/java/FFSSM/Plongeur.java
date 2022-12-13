package FFSSM;

//import sun.util.resources.cldr.ext.LocaleNames_xh;

import java.time.LocalDate;
import java.util.TreeSet;

public class Plongeur extends Personne{
    private int niveau;
    private GroupeSanguin groupeSanguin;
    TreeSet<Licence> listelicence = new TreeSet<>();

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau,GroupeSanguin groupeSanguin){
        super(numeroINSEE,nom,prenom,adresse,telephone,naissance);
        this.niveau=niveau;
        this.groupeSanguin=groupeSanguin;
    }

    public void ajouterLicence(String numero, LocalDate delivrance,Club c){
        Licence l = new Licence(this,numero,delivrance,c);
        listelicence.add(l);
    }

    public Licence derniereLicence(){
        return listelicence.last();
    }
	
}
