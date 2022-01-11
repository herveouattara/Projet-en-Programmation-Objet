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
public class Teleporteur extends Piege {

	private Position arriver;

	public Teleporteur(int p, Position pos, Position arriver) {
		super(p, "Teleporteur", pos);
		this.arriver = arriver;
	}

	public void action() {
		super.getParticule().setPosition(this.arriver);
	}

}