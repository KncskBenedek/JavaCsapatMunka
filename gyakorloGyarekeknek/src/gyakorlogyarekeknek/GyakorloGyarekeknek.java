package gyakorlogyarekeknek;


import java.util.Arrays;
import java.util.Locale;
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
        } while (beAkarMeg("Akar más féle feladatokat megoldani? Igen:I || Nem:N"));//rossz
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
        kiiras(szam1+"/"+szam2+" = "+(szam1/szam2)+" Ennyiszer generált újjat: "+szamlalao);
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
       kiiras(szam1+"/"+szam2+" = "+(szam1/szam2)+" Ennyiszer generált újjat: "+szamlalao);
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
        kiiras(szam1+"/"+szam2+" = "+(szam1/szam2)+" Ennyiszer generált újjat: "+szamlalao);
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
        kiiras(szam1+"/"+szam2+" = "+(szam1/szam2)+" Ennyiszer generált újjat: "+szamlalao);
        //System.out.println(szam1+"/"+szam2+" = "+(szam1/szam2)+" Ennyiszer generált újjat: "+szamlalao);
        return false;
        
    }

    private static String ellenorzesInt(String valasz) {
        Scanner scr = new Scanner(System.in);
        boolean isNumeric = valasz.chars().allMatch( Character::isDigit );
        while(!isNumeric){
            kiiras("Kérem számot adjon meg: ");
            //System.out.println("Kérem számot adjon meg: ");
            valasz =scr.nextLine();
            isNumeric = valasz.chars().allMatch( Character::isDigit );
        }
        return valasz;
    }


    private static int feladatOsszeAllit(char feladatTipusa) {
        
           int szam1 = rndszamGeneralas();
           int szam2 = rndszamGeneralas();
           int vegeredmeny=0;
           
           if (feladatTipusa =='+') {
               kiiras(szam1+"+"+szam2);
               vegeredmeny=szam1+szam2;
           } else if (feladatTipusa=='-'){
               kiiras(szam1+"-"+szam2);
                vegeredmeny=szam1-szam2;
           } else if (feladatTipusa=='*'){
               kiiras(szam1+"*"+szam2);
                vegeredmeny=szam1*szam2;
           } else if (feladatTipusa=='/'){
               kiiras(szam1+"/"+szam2);
                vegeredmeny=szam1/szam2;
           }
           /* 
           
        switch (bekerFeladatTipus()) {
            case bekerFeladatTipus()=='+':
                kiiras(szam1+"+"+szam2);
               vegeredmeny=szam1+szam2;
            case '-':
                kiiras(szam1+"-"+szam2);
                vegeredmeny=szam1-szam2;
            case '/':
                kiiras(szam1+"/"+szam2);
                vegeredmeny=szam1/szam2;
            case '*':
                kiiras(szam1+"*"+szam2);
                vegeredmeny=szam1*szam2;
        }
           */
           return vegeredmeny;
        }  

    private static char bekerFeladatTipus() {
        //System.out.println("Kéremd adja meg milyen alapműveletet szeretne[+ - * /]");
        kiiras("Kérem adja meg milyen alapműveletet szeretne[+ - * /]");
        Scanner sc = new Scanner(System.in);
        char muvjel = sc.next().charAt(0);
        //boolean muvelet = (muvjel == '+' || muvjel == '-' || muvjel == '/' || muvjel == '*');
        while (!((muvjel == '+' || muvjel == '-' || muvjel == '/' || muvjel == '*'))) {
            kiiras("Nem jo a muvelet!");
            muvjel = sc.next().charAt(0);
        }
        return muvjel;

    } 




    private static int bekerValasz() {
        Scanner scr = new Scanner(System.in);
        kiiras("Kérem adja meg a megoldást: ");
        //System.out.println("Kérem adja meg a megoldást: ");
        String valasz =scr.nextLine();
        valasz =ellenorzesInt(valasz);
        int megoldas = Integer.parseInt(valasz);
        return megoldas;
    }

    private static void torzs() {
       char feladatTipus = bekerFeladatTipus();
       int hely = opHelye(feladatTipus);
        do {
           int megoldas = feladatOsszeAllit(feladatTipus);
           hanyDBfeladat[hely] += 1;
           int felhaszValasz = bekerValasz();
           if(felhaszValasz != megoldas){
               rosszMegoldasok[hely] += 1;
               kiiras("Rossz megoldást adott meg!");
               //System.out.println("Rossz megoldást adott meg!");
           }else{
               kiiras("jó megoldást adott meg!");
               //System.out.println("jó megoldást adott megg!");
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
            valasz = valasz.toLowerCase();
            if (valasz.equals("i")) {
                tovabb = true;
                jo = true;
            }else if(valasz.equals("n")){
                jo = true;
                tovabb = false;
            }else{
                kiiras("Rossz adat! Adja meg újra!");
                //System.out.println("Rossz adat! Adja meg újra!");
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
        int legtobbHiba = maxErtek();
        System.out.println("123");
    }

    private static int maxErtek() {
        int i = 1;
        int legNagyHely = 0;
        int hossz = rosszMegoldasok.length;
        while (i < hossz) {
            if (rosszMegoldasok[i] > rosszMegoldasok[legNagyHely]) {
                legNagyHely = i;
            }
            i++;
        }
        return legNagyHely;
    }


    private static void kiiras(String szoveg) {
        System.out.println(szoveg);
    }
    

}