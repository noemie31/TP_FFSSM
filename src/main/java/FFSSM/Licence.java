/**
 * @(#) LicencePlongeur.java
 */
package FFSSM;

//import jdk.vm.ci.meta.Local;

import java.time.LocalDate;
import java.util.Objects;

public class Licence implements Comparable<Licence> {

    private Personne possesseur;

    private String numero;

    private LocalDate delivrance;

    private Club club;

    public Licence(Personne possesseur, String numero, LocalDate delivrance, Club club) {
        this.possesseur = possesseur;
        this.numero = numero;
        this.delivrance = delivrance;
        this.club = club;
    }

    public Personne getPossesseur() {
        return possesseur;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDelivrance() {
        return delivrance;
    }

    public Club getClub() {
        return club;
    }

    /**
     * Est-ce que la licence est valide à la date indiquée ?
     * Une licence est valide pendant un an à compter de sa date de délivrance
     * @param d la date à tester
     * @return vrai si valide à la date d
     **/
    public boolean estValide(LocalDate d) {
        LocalDate dvalide = delivrance.plusYears(1);
        return d.isBefore(dvalide);
    }

    @Override
    public int compareTo(Licence l) {
        int res=0;
        if(this.delivrance.isAfter(l.getDelivrance())) res=1;
        else res=-1;
        return res;
    }
}
