package gyakorlogyarekeknek;


import java.util.Arrays;
import java.util.Random;


import java.util.Scanner;



public class GyakorloGyarekeknek {
    //static változók
    static char[] operatorok = {'+', '-', '*', '/'};
    static int[] rosszMegoldasok = new int[4];
    static int[] hanyDBfeladat = new int[4];
    
    
    public static void main(String[] args) {

        do {
            torzs();
        } while ();
        statisztika();
    }

    private static boolean osszeadasEllenorzes(int szam1, int szam2) {
       Random rnd = new Random();
       int szamlalao = 0;
       while((szam1 + szam2) > 100){
         szam1 = rnd.nextInt(99 - 1)+ 1;
         szam2 = rnd.nextInt(99 - 1)+ 1;
         szamlalao++;
     }
        System.out.println(szam1+"+"+szam2+" = "+(szam1+szam2)+" Ennyiszer generált újjat: "+szamlalao);
       return true;
     
    }

    private static boolean szorzatEllenorzes(int szam1, int szam2) {
        Random rnd = new Random();
        int szamlalao = 0;
       while((szam1 * szam2) > 100){
        szam1 = rnd.nextInt(99 - 1)+ 1;
        szam2 = rnd.nextInt(99 - 1)+ 1;
        szamlalao++;
     }
       System.out.println(szam1+"*"+szam2+" = "+(szam1*szam2)+" Ennyiszer generált újjat: "+szamlalao);
       return true;

    }

    private static boolean kivonasEllenorzes(int szam1, int szam2) {
        Random rnd = new Random();
        int szamlalao = 0;
        while((szam1 - szam2) <= 0){
            szam1 = rnd.nextInt(99 - 1)+ 1;
            szam2 = rnd.nextInt(99 - 1)+ 1;
            szamlalao++;
     }
        System.out.println(szam1+"-"+szam2+" = "+(szam1-szam2)+" Ennyiszer generált újjat: "+szamlalao);
        return false;

    }

    private static boolean osztasEllenorzes(int szam1, int szam2) {
        Random rnd = new Random();
        int szamlalao = 0;
        while(szam1 % szam2 != 0){
            szam1 = rnd.nextInt(99 - 1)+ 1;
            szam2 = rnd.nextInt(99 - 1)+ 1;
            szamlalao++;
     }
        System.out.println(szam1+"/"+szam2+" = "+(szam1/szam2)+" Ennyiszer generált újjat: "+szamlalao);
        return false;


        bekerFeladatTipus();
        int valasz = feladatOsszeAllit();
        kiir();
        bekerValasz();
        
        
      
      

    }

    
    
    
    private static int feladatOsszeAllit() {
           return null;
    }

    private static char bekerFeladatTipus() {
        return null;
    }


    private static void kiir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void bekerValasz() {

    }

    private static void torzs() {
       char feladatTipus = bekerFeladatTipus();
       int hely = opHelye(feladatTipus);
        do {
           int megoldas = feladatOsszeAllit();
           hanyDBfeladat[hely] += 1;
           int felhaszValasz = bekerValasz();
           if(felhaszValasz != megoldas){
               rosszMegoldasok[hely] += 1;
               System.out.println("Rossz megoldást adott meg!");
           }else{
               System.out.println("jó megoldást adott megg!");
           }
           
        } while (beAkarMeg("Akar még feladatot? Igen:I || Nem:N"));
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

    private static void statisztika() {
        
        System.out.println("");
    }
 
}
