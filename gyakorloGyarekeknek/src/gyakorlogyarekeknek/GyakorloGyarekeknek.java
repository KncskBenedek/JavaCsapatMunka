package gyakorlogyarekeknek;


import java.util.Random;
import java.util.Scanner;

public class GyakorloGyarekeknek {
    public static void main(String[] args) {   
        
    }
    //static változók
    static char[] operatorok = {'+', '-', '*', '/'};
    static int[] rosszMegoldasok = new int[4];  
    public static void main(String[] args) {

        do {
            valami();
        } while (true);

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
        
    private static char bekerFeladatTipus() {
        
        return '0';
        
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
  
