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
public class Direction {
    
    private int dx;
	private int dy;

	public Direction(int x, int y) { // constructeur standard
		this.dx = x;
		this.dy = y;
	}

	public void rotateRight() { // tourne dans le sens horaire
		if (this.dx == 0) { // on test la direction en x
			if (this.dy == 1) {this.dy = 0; this.dx = 1;}
			if (this.dy == -1) {this.dy = 0; this.dx = -1;}
		}
		if (this.dy == 0) { // on test la direction en y
			if (this.dx == 1) {this.dy = -1; this.dx = 0;}
			if (this.dx == -1) {this.dy = 1; this.dx = 0;}
		}
	}

	public void rotateLeft() { //tourne dans le sens anti-horaire
		if (this.dx == 0) { // on test la direction en x
			if (this.dy == 1) {this.dy = 0; this.dx = -1;}
			if (this.dy == -1) {this.dy = 0; this.dx = 1;} 
		}
		if (this.dy == 0) { // on test la direction en y
			if (this.dx == 1) {this.dy = 1; this.dx = 0;}
			if (this.dx == -1) {this.dy = -1; this.dx = 0;}
		}
	}

	public int getDX() {return this.dx;} // renvoi la direction en x
	public int getDY() {return this.dy;} // renvoi la direction en y

	public void setDirection(int x, int y) {this.dx = x; this.dy = y;} // définie une nouvelle direction



}
    

