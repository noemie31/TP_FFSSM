/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.HashSet;
import java.util.Set;

public class Club {

    private Set<Plongee> listeplongee = new HashSet<Plongee>();
    private Set<Licence> licencesdelivree = new HashSet<Licence>();

    private Moniteur president;

    private String nom;

    private String adresse;

    private String telephone;

    public Club(Moniteur président, String nom, String adresse, String telephone) {
        this.president = président;
        this.nom = nom;
        this.adresse=adresse;
        this.telephone = telephone;
    }

    /**
     * Calcule l'ensemble des plongées non conformes organisées par ce club.
     * Une plongée est conforme si tous les plongeurs de la palanquée ont une licence
     * valide à la date de la plongée
     * @return l'ensemble des plongées non conformes
     */
    public Set<Plongee> plongeesNonConformes() {
         Set<Plongee> plongeeNonConforme = new HashSet<Plongee>();
         for(Plongee p : listeplongee){
             if(!p.estConforme()){
                 plongeeNonConforme.add(p);
             }
         }
         return plongeeNonConforme;
    }

    /**
     * Enregistre une nouvelle plongée organisée par ce club
     * @param p la nouvelle plongée
     */
    public void organisePlongee(Plongee p) {
         listeplongee.add(p);
    }

    public void ajouterLicence(Licence l){
        licencesdelivree.add(l);
    }
    
    
    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur président) {
        this.president = président;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

}
