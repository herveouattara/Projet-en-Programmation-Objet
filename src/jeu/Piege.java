/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

/**
 *
 * @author zzzz
 */
public class Piege {
    
    
	private int poid;
	private String name;
	private Position position;
	private Particule particule;

	public Piege(int p, String nm, Position pos) {
		this.poid = p;
		this.name = nm;
		this.position = pos;
	}

	public void setName(String nm) {this.name = nm;} // définie le nom du piege
	public String getName() {return this.name;} // renvoi le nom du piege

	public void setPoid(int p) {this.poid = p;} // définie le poid du piege
	public int getPoid() {return this.poid;} // renvoi le poid du piege

	public void setPosition(Position pos) {this.position = pos;} // définie la position du piege
	public Position getPosition() {return this.position;} // renvoi la position du piege

	public void setParticule(Particule p) {this.particule = p;} // définie la particule sur laquel le piège agit
	public Particule getParticule() {return this.particule;} // renvoi la particule sur laquel le piège agit

	public boolean poidEquals(Particule p) { // vérifie si le piège peut agir sur la particule donné
		boolean r = false;
		if (p.getPoid() >= this.getPoid()) { r = true;}
		return r;
	}

	public void action() {}

	public void catchParticule(Particule p) { // recupère la particule donné si son poid est supèrieur a celui du piège
		if (this.poidEquals(p)) {this.particule = p;}
	}

}  