package gyakorlogyarekeknek;

import java.util.Random;
import java.util.Scanner;


public class GyakorloGyarekeknek {
    //static változók
    static char[] operatorok = {'+', '-', '*', '/'};
    static int[] rosszMegoldasok = new int[4];
    
    
    public static void main(String[] args) {
        do {
            valami();
        } while ();
    }

    
    
    
    private static int feladatOsszeAllit() {
           
    }

    private static char bekerFeladatTipus() {
        return ;
    }

    private static int feladat() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void kiir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void bekerValasz() {
        
    }

    private static void valami() {
       char feladatTipus = bekerFeladatTipus();
       int hely = opHelye();
        do {
           int megoldas = feladatOsszeAllit();
           int felhaszValasz = bekerValasz();
           if(felhaszValasz != megoldas){
               rosszMegoldasok[hely] += 1;
               
           }
           
        } while (beAkarMeg("\"Akar még feladatot? Igen:I || Nem:N\""));
    }

    private static boolean beAkarMeg(String szoveg) {
        Scanner scan = new Scanner(System.in);
        boolean jo = false;
        boolean tovabb = false;
        String valasz;
        do {
            System.out.println(szoveg); //"Akar még feladatot? Igen:I || Nem:N"
            valasz = scan.nextLine();
            if (valasz.equals("I")) {
                tovabb = true;
                jo = true;
            }else if(valasz.equals("N")){
                jo = true;
                tovabb = false;
            }else{
                System.out.println("Rossz adat! Adja meg újra!");
            }
            
        } while (!jo);
        return tovabb;
    }

    private static int opHelye(char feladatTipus) {
        int helye;
        int hossz=operatorok.length;
        int i = 0;
        while (!(feladatTipus == operatorok[i])) {
            i++;
        }
        return i;
    }
 
}
