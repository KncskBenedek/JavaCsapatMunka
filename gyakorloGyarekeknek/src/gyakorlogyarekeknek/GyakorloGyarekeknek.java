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
        Scanner sc = new Scanner(System.in);
        char muvjel = sc.next().charAt(0);
        boolean muvelet = (muvjel == '+' || muvjel == '-' || muvjel == '/' || muvjel == '*');
        while (!(muvelet)) {            
            muvjel = sc.next().charAt(0);
        }
        return muvjel;
    }

    private static int feladat() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void kiir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static bekerValasz() {
        return null;
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

    private static int opHelye() {
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
