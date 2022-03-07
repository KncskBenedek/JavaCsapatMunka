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
        } while (false);//rossz
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


    private static int feladatOsszeAllit() {
        
           int szam1 = rndszamGeneralas();
           int szam2 = rndszamGeneralas();
           int vegeredmeny=0;
           
        switch (bekerFeladatTipus()) {
            case '+':
               vegeredmeny=szam1+szam2;
                
            case '-':
                vegeredmeny=szam1-szam2;
            case '/':
                vegeredmeny=szam1/szam2;
            case '*':
                vegeredmeny=szam1*szam2;
        }
           return vegeredmeny;
        } 

    private static char bekerFeladatTipus() {
        System.out.println("Kéremd adja meg milyen alapműveletet szeretne[+ - * /]");
        Scanner sc = new Scanner(System.in);
        char muvjel = sc.next().charAt(0);
        boolean muvelet = (muvjel == '+' || muvjel == '-' || muvjel == '/' || muvjel == '*');
        while (!(muvelet)) {            
            muvjel = sc.next().charAt(0);
        }
        return muvjel;

    }


    private static void kiir() {
        System.out.println("123");
    }

    private static int bekerValasz() {
        Scanner scr = new Scanner(System.in);
        System.out.println("Kérem adja meg a megoldást: ");
        String valasz =scr.nextLine();
        valasz =ellenorzesInt(valasz);
        int megoldas = Integer.parseInt(valasz);
        return megoldas;
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
    
 

    private static int rndszamGeneralas() {
       Random rnd = new Random();
       int rndszam = rnd.nextInt(99 - 1)+ 1;
       return rndszam;

}

    static void statisztika() {
        System.out.println("123");
    }
}