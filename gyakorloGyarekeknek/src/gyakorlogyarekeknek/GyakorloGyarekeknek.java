package gyakorlogyarekeknek;

import java.util.Random;
import java.util.Scanner;


public class GyakorloGyarekeknek {
    
    static int[] rosszMegoldasok = new int[4];
    public static void main0(String[] args) {
        do {
            valami();
        } while ();
    }

    
    
    
    private static int feladatOsszeAllit() {
           
    }

    private static int bekerFeladatTipus() {
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
       int feladatTipus = bekerFeladatTipus();
        do {
           int megoldas = feladatOsszeAllit();
           
           
        } while (beAkarMeg());
    }

    private static boolean beAkarMeg() {
        Scanner scan = new Scanner(System.in);
        boolean jo = false;
        boolean tovabb = false;
        String valasz;
        do {
            System.out.println("Akar még feladatot? Igen:I || Nem:N");
            valasz = scan.nextLine();
            if (valasz.equals("I")) {
                tovabb = true;
                jo = true;
            }else if(valasz.equals("N")){
                jo = true;
                tovabb = false;
            }else{
                System.out.println("Rossz válasz! Adja meg újra!");
            }
            
        } while (!jo);
        return tovabb;
    }
    
    public static void main(String[] args) {
          Random rnd = new Random();
            
            for (int i = 0; i < 100; i++) {
                int szam = rnd.nextInt(100-1+1)+1;
                System.out.println(szam);
            
        }
    }
    
            }
