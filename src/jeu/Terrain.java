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
public class Terrain {
   

	Piege[][] grid;
	int x;
	int y;

	public Terrain(int x, int y) { // constructeur standard
		this.x = x; // on définie la longueur du terrain
		this.y = y; // on définie la largeur du terrain

		this.grid = new Piege[this.x][this.y]; // on crée la grille du terrain
	}

	public Terrain() {this(10,10);} // constructeur par défault

	public void addPiege(Piege p) { // ajoute un piege au terrain si la position est libre

		int x = p.getPosition().getX();
		int y = p.getPosition().getY();

		if (this.grid[x][y] == null && x < this.x && y < this.y) {this.grid[x][y] = p;}

	}

	public void forceAddPiege(Piege p) { // force l'ajout d'un piege sur une position

		int x = p.getPosition().getX();
		int y = p.getPosition().getY();

		if (x < this.x && y < this.y) {this.grid[x][y] = p;}

	}

	public void removePiege(int x, int y) {this.grid[x][y] = null;} // retire un piege au coordonné donnés

	public Piege getPiege(int x, int y) {return this.grid[x][y];} // renvoi l'entité présente au coordonné donnés

	public int getSizeX() {return this.x;}
	public int getSizeY() {return this.y;}

	public void initSimple() {
		this.grid[1][2] = new Teleporteur(5, new Position(1,2), new Position(3,5));
		this.grid[2][9] = new Deviateur(6, new Position(2,9), 0);
		this.grid[3][1] = new Prison(4, new Position(3,1));
		this.grid[4][0] = new Teleporteur(3, new Position(4,2), new Position(7,1));
		this.grid[5][7] = new Teleporteur(8, new Position(5,7), new Position(1,7));
		this.grid[6][4] = new Deviateur(2, new Position(6,4), 1);
		this.grid[7][8] = new Teleporteur(7, new Position(2,6), new Position(4,6));
		this.grid[8][3] = new Deviateur(4, new Position(8,3), 0);
		this.grid[0][5] = new Prison(1, new Position(0,5));
	}

	public String toString() {
		String r = "";

		for (int i = 0; i < this.y; i++) {
			for (int j = 0; j < this.x; j++) {

				if (this.getPiege(j,i) != null) {
					r += " " + this.getPiege(j,i).getName().charAt(0) + this.getPiege(j,i).getPoid();
				}
				else {r += " 00";}

			} //2
			r += "\n";
		} //1

		return r;
	}

}
