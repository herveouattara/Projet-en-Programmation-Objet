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
public class Particule {
    
    private int poid;
	private Direction direction;
	private Position position;
        private Terrain terrain;

	public Particule(int p, Position pos, Terrain t) {
		this.poid = p; // on définie le poid de la particule
		this.position = pos; // on définie la position de la particule
		this.terrain = t;

		this.initDirection(terrain.getSizeX(), terrain.getSizeY()); // on initialise la direction de la particule
	}

	private void initDirection(int sx, int sy) {

		int x = this.position.getX(); //on recupère l'absice de départ
		int y = this.position.getY(); //on recupère l'ordonne d'arrivé

		if (x < 0) {this.direction = new Direction(1,0);}
		if (y < 0) {this.direction = new Direction(0,1);}
		if (x >= sx) {this.direction = new Direction(-1,0);}
		if (y >= sy) {this.direction = new Direction(0,-1);}

		if (x > sx && y > sy) {} // demander une nouvelle position de départ

	}

	public void setPoid(int p) {this.poid = p;}
	public int getPoid() {return this.poid;}

	public void setDirection(Direction d) {this.direction = d;}
	public Direction getDirection() {return this.direction;}

	public void setPosition(Position pos) {this.position = pos;}
	public Position getPosition() {return this.position;}

	public void move() {this.position.setMove(this.direction);}

	public boolean active() {
		boolean r = true;

		if (this.direction == null) {r = false;}
		if (this.direction.getDX() == 0 && this.direction.getDY() == 0) {r = false;}
		if (this.position.getX() >= this.terrain.getSizeX() || this.position.getY() >= this.terrain.getSizeY() || this.position.getX() == -1 || this.position.getY() == -1) {r = false;}


		return r;
	}

} 