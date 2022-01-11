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
public class Jeu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Terrain terrain = new Terrain();
		terrain.initSimple();
		Joueur joueur = new Joueur();
		int option, stCredit = 20;
		boolean quit = false;

		joueur.setPseudo(Lire.S("Entrez le nom du joueur >> "));
		
		do {
			System.out.println("##### MENU #####");
			System.out.println("1. Lancer une partie ");
			System.out.println("2. Creer Terrain de jeu");
			System.out.println("3. Option");
			System.out.println("4. Apercu du Terrain de jeu (Devoile la carte)");
			System.out.println("5. Quitter");
			option = Lire.i("\nEntrez votre choix >> ");

			if (option == 1) {

				joueur.setCredit(stCredit);
				boolean inGame = true;
				int n = 1;

				while (inGame == true) {

					System.out.println("##### Tour n(" + n + ") de " + joueur.getPseudo() + " #####");
					int jpx = Lire.i("entrez la position en X de la particule de -1 a " + terrain.getSizeX() + " >> ");
					int jpy = Lire.i("entrez la position en X de la particule de -1 a " + terrain.getSizeY() + " >> ");
					int jpoid = Lire.i("entrez le poid de votre particule (vous avez " + joueur.getCredit() + " Credit) >> ");

					Particule jp = new Particule(jpoid, new Position(jpx, jpy), terrain);
					joueur.setParticule(jp);
					joueur.removeCredit(jpoid);

					int moveCount = 0;

					do {
						moveCount++;
						jp.move();
						try {
							if (terrain.getPiege(jp.getPosition().getX(), jp.getPosition().getY()) != null) {
								terrain.getPiege(jp.getPosition().getX(), jp.getPosition().getY()).catchParticule(jp);
								try {terrain.getPiege(jp.getPosition().getX(), jp.getPosition().getY()).action();}
									catch (java.lang.NullPointerException e) {}
							}
						} catch(java.lang.ArrayIndexOutOfBoundsException e) {};
					} while(jp.active() == true && moveCount < 100);

					if (jp.getPosition().getX() < 0 || jp.getPosition().getX() > 9 || jp.getPosition().getY() < 0 || jp.getPosition().getY() > 9) {
						joueur.addCredit(jp.getPoid());
					}

					System.out.print("finie en " + jp.getPosition().getX() + "," + jp.getPosition().getY());
					System.out.println(" en " + moveCount + " mouvement");
					n++;

					System.out.println("<o>---- Predire un piege ----<o>");
					System.out.println("1. Deviateur");
					System.out.println("2. Teleporteur");
					System.out.println("3. Prison");
					int choixType = Lire.i("\n votre prediction de type >> ");
					int choixPosX = Lire.i("\n votre prediction de postion en X >> ");
					int choixPosY = Lire.i("\n votre prediction de postion en Y >> ");

					Piege piege = terrain.getPiege(choixPosX, choixPosY);

					boolean uncover = false;

					try {if (piege.getName() == "Deviateur" && choixType == 1) {uncover = true;}} catch (java.lang.NullPointerException e) {}
					try {if (piege.getName() == "Teleporteur" && choixType == 2) {uncover = true;}} catch (java.lang.NullPointerException e) {}
					try {if (piege.getName() == "Prison" && choixType == 3) {uncover = true;}} catch (java.lang.NullPointerException e) {}

					if (uncover == true) {
						joueur.addCredit(piege.getPoid() * 2);
						terrain.removePiege(choixPosX, choixPosY);
					}

					if (Lire.i("voulez vous continuer (1 oui, 0 non) >> ") == 0) {inGame = false;}

				}

				System.out.println("vous avez fait un score de " + (joueur.getCredit() + joueur.getParticule().getPoid()));
				terrain.initSimple();

			}
			if (option == 2) {
				terrain = edit();
			}
			if (option == 3) {
				System.out.println("Credit de depart : " + stCredit);
				stCredit = Lire.i("entrez la nouvelle option de credit de depart >> ");
			}
			if (option == 4) {afficher(terrain);}
			if (option == 5) {quit = true;}

		} while (quit == false);

	}

	public static void afficher(Terrain t) {
		System.out.println(t.toString());
	}

	public static Terrain edit() {

		int sizeX = Lire.i("entrez la taille en X du terrain >> ");
		int sizeY = Lire.i("entrez la taille en Y du terrain >> ");

		Terrain terrain = new Terrain(sizeX, sizeY);
		Piege p = new Piege(0, "null", new Position(0,0));
		int option;
		boolean retour = false;

		do {
			System.out.println("##### EDITION DE TERRAIN #####");
			System.out.println("1. Ajouter un piege");
			System.out.println("2. Retirer un piege");
			System.out.println("3. Apercu");
			System.out.println("4. Retour");

			option = Lire.i("choisir une option >> ");

			if (option == 1) {

				System.out.println("1. Deviateur");
				System.out.println("2. Teleporteur");
				System.out.println("3. Prison");
				int type = Lire.i("entrez le type du piege a ajouter >> ");
				int px = Lire.i("entrez la position en X du piege a ajouter >> ");
				int py = Lire.i("entrez la position en Y du piege a ajouter >> ");
				int poid = Lire.i("entrez le poid du piege a ajouter >> ");

				if (type == 1) {
					int sens = Lire.i("entrez le sens du deviateur (0 horaire, 1 anti-horaire) >> ");
					p = new Deviateur(poid, new Position(px, py), sens);
				}
				if (type == 2) {
					int tx = Lire.i("entrez la position en X d'arriver >>");
					int ty = Lire.i("entrez la position en Y d'arriver >>");
					p = new Teleporteur(poid, new Position(px, py), new Position(tx, ty));
				}
				if (type == 3) {
					p = new Prison(poid, new Position(px, py));
				}

					int force = Lire.i("souhaitez vous forcer l'ajout du piege crée (1 oui, 0 non) >> ");
					if (force == 0)
						terrain.addPiege(p);
					if (force == 1)
						terrain.forceAddPiege(p);

			}
			if (option == 2) {
				int px = Lire.i("entrez la position en X du piege a retirer >> ");
				int py = Lire.i("entrez la position en Y du piege a retirer >> ");

				terrain.removePiege(px, py);
			}
			if (option == 3) {afficher(terrain);}
			
			if (option == 4) {retour = true;}

		} while (retour == false);

		return terrain;

	}

}

