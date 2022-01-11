/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

import java.io.IOException;

/**
 *
 * @author ouatt
 */
public class Lire {
    
    public static String S(String prt) { // Lire un String
		
    System.out.println(prt);

    String tmp = "";
		char C='\0'; 
		try {
         	while ((C=(char) System.in.read()) !='\n') {
          		if (C != '\r')  tmp = tmp+C;
          	}
        }     
 		catch (IOException e) {
          	System.out.println("Erreur de frappe");
          	System.exit(0);
        } 
 		return tmp;
	} // fin de S()

 	public static byte b(String prt)  // Lire un entier byte
 {
         byte x=0;
                try {
                         x=Byte.parseByte(S(prt));
                        }
                catch (NumberFormatException e) {
          System.out.println("Format numÈrique incorrect");
          System.exit(0);
    }     
          return x ;
 }        
          
 public static short s(String prt)  // Lire un entier short
 {
         short x=0;
                try {
                         x=Short.parseShort(S(prt));
                        }
                catch (NumberFormatException e) {
          System.out.println("Format numÈrique incorrect");
          System.exit(0);
    }     
          return x ;
 }        
          
          
 public static int i(String prt)  // Lire un entier
 {
         int x=0;
                try {
                         x=Integer.parseInt(S(prt));
                }        
                catch (NumberFormatException e) {
          System.out.println("Format numÈrique incorrect");
          System.exit(0);
    }     
          return x ;
 }        
          
 public static long l(String prt)  // Lire un entier long
 {
         long x=0;
                try {
                         x=Integer.parseInt(S(prt));
                }        
                catch (NumberFormatException e) {
          System.out.println("Format numÈrique incorrect");
          System.exit(0);
    }     
          return x ;
 }        
          
          
 public  static double d(String prt)  // Lire un double
 {
        double x=0.0;
                try {
                        x=Double.valueOf(S(prt)).doubleValue();
                }    
                catch (NumberFormatException e) {
          System.out.println("Format numÈrique incorrect");
          System.exit(0);
    }     
          return x ;
 }        
          
 public  static float f(String prt)  // Lire un float
 {
   float x=0.0f;
        try {
                x=Double.valueOf(S(prt)).floatValue();
        }    
        catch (NumberFormatException e)
        {
          System.out.println("Format numÈrique incorrect");
          System.exit(0);
    }     
          return x ;
 }        
          
          
 public  static char c(String prt)  // Lire un caractere
 {
  String tmp=S(prt);
  if (tmp.length()==0)
          return '\n';
  else    
                {
                return tmp.charAt(0);
                }
 }        
}        
