/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    private int numeroDiplome;
    private List<Embauche> listeEmbauches = new ArrayList<Embauche>();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin groupeSanguin, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance,niveau,groupeSanguin);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        Club club=null;
        if(!listeEmbauches.isEmpty()){
            Embauche em = listeEmbauches.get(listeEmbauches.size()-1);
            club = em.getEmployeur();
            if (em.estTerminee()){
                club=null;
            }
        }
        Optional<Club> oc = Optional.ofNullable(club);
        return oc;
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {   
        if(!listeEmbauches.isEmpty()){
            this.terminerEmbauche(debutNouvelle);
        }
        listeEmbauches.add(new Embauche(debutNouvelle,this,employeur));
    }

    public void terminerEmbauche(LocalDate date){
        if(!listeEmbauches.get(listeEmbauches.size()-1).estTerminee()){
            listeEmbauches.get(listeEmbauches.size()-1).setFin(date);
        }
    }

    public List<Embauche> emplois() {
         return listeEmbauches;
    }

}
