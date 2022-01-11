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
public class Position {
    
    private int x;
	private int y;

	public Position(int x, int y) {
		this.x = x; this.y = y;
	}

	public void setMove(Direction d) { // définie la position en fonction de la position précédante et d'une direction
		this.x += d.getDX();
		this.y += d.getDY();
	}

	public void setX(int x) {this.x = x;} // définie la position en x
	public void setY(int y) {this.y = y;} // définie la position en y

	public int getX() {return this.x;} // renvoi la position en x
	public int getY() {return this.y;} // renvoi la position en y

	public boolean equals(Position pos) { // vérifie si deux position sont identiques
		boolean r = false;
		if (this.x == pos.getX() && this.y == pos.getY()) {r = true;}
		return r;
	}

}
