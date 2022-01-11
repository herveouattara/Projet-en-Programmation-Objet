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
public class Deviateur extends Piege {
    
   

	private int sens;

	public Deviateur(int p, Position pos, int s) {
		super(p, "Deviateur", pos);
		this.sens = s;
	}

	public void action() {
		if (this.sens == 0) { super.getParticule().getDirection().rotateRight();}
		if (this.sens == 1) { super.getParticule().getDirection().rotateLeft();}
	}

}
   
