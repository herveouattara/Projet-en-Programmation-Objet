
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

/**
 *
 * @author ouatt
 */
public class Joueur {
    
    private String pseudo;
	private int credit;
	private Particule particule;


	public Joueur(String ps) { //constructeur du joueur
		this.pseudo = ps;
		this.credit = 0;
	}
	public Joueur() {
		this.credit = 0;
	}

	public void setCredit(int c) {this.credit = c;} // on définie le credit
	public void addCredit(int c) {this.credit += c;} // on ajoute du credit au credit existant
	public void removeCredit(int c) {this.credit += -c;} // on retire du credit au credit existant
	public int getCredit() {return this.credit;} // renvoi le credit du joueur

	public void setPseudo(String ps) {this.pseudo = ps;} // definit le pseudo du joueur
	public String getPseudo() {return this.pseudo;} // renvoi le pseudo du joueur

        
	public void setParticule(Particule p) {this.particule = p;} // définie la particule courante du joueur
	public Particule getParticule() {return this.particule;} // renvoie la particule actuelle du joueur
    
}
