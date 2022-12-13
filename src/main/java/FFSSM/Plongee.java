/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Plongee {

	private Set<Plongeur> palanquee = new HashSet<Plongeur>();

	private Site lieu;

	private Moniteur chefDePalanquee;

	private LocalDate date;

	private int profondeur;

	private int duree;

	public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
		this.lieu = lieu;
		this.chefDePalanquee = chefDePalanquee;
		this.date = date;
		this.profondeur = profondeur;
		this.duree = duree;
	}

	public void ajouteParticipant(Plongeur participant) {
		palanquee.add(participant);
	}

	public LocalDate getDate() {
		return date;
	}

	public Set<Plongeur> getPalanquee(){
		return palanquee;
	}

	/**
	 * Détermine si la plongée est conforme. 
	 * Une plongée est conforme si tous les plongeurs de la palanquée ont une
	 * licence valide à la date de la plongée
	 * @return vrai si la plongée est conforme
	 */
	public boolean estConforme() {
		boolean b = false;
		for (Plongeur p : palanquee){
			if(!p.derniereLicence().estValide(date)){
				b = true;
			}
		}
		return b;
	}

}
