package gyakorlogyarekeknek;

import java.util.Random;
import java.util.Scanner;

public class GyakorloGyarekeknek {
    public static void main0(String[] args) {   
        bekerFeladatTipus();
        int valasz = feladatOsszeAllit();
        kiir();
        bekerValasz();
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
    }    
        
    private static int feladatOsszeAllit() {
           
        return 0;
           
    }

    private static void bekerFeladatTipus() {
        
        
    }

    private static int feladat() {

        return 0;

    }

    private static void kiir() {
    }
    private static String ellenorzesInt(String valasz) {
        Scanner scr = new Scanner(System.in);
        boolean isNumeric = valasz.chars().allMatch( Character::isDigit );
        while(!isNumeric){
            System.out.println("Kérem számot adjon meg: ");
            valasz =scr.nextLine();
            isNumeric = valasz.chars().allMatch( Character::isDigit );
        }
        return valasz;
    }
    
    private static int bekerValasz() {
        Scanner scr = new Scanner(System.in);       
        System.out.println("Kérem adja meg a megoldást: ");   
        String valasz =scr.nextLine();
        valasz =ellenorzesInt(valasz);
        int megoldas = Integer.parseInt(valasz);
        return megoldas;
        
    }
    public static void main(String[] args) {
        bekerValasz();
    }
        
        
      
      
    }



