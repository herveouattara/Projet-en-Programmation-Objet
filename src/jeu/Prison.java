

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
public class Prison extends Piege {

	private boolean lock = false;
	private Direction dTmp;

	public Prison(int p, Position pos) {
		super(p, "Prison", pos);
	}

	public void action() {
		if (this.lock == false) {
			this.dTmp = super.getParticule().getDirection();
			super.getParticule().setDirection(new Direction(0,0));
		}
		else {
			super.getParticule().setDirection(this.dTmp);
		}
	}

}
    

