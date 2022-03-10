package gyakorlogyarekeknek;

import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//import static java.util.Comparator.reverseOrder;
//import java.util.Locale;
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

    private static boolean osszeadasEllenorzes(int szam1, int szam2) { // nincs használva
        Random rnd = new Random();
        while ((szam1 + szam2) > 100) {
            szam1 = rnd.nextInt(99) + 1;
            szam2 = rnd.nextInt(99) + 1;
        }
        return true;

    }

    private static boolean szorzatEllenorzes(int szam1, int szam2) { // nincs használva
        Random rnd = new Random();
        while ((szam1 * szam2) > 100) {
            szam1 = rnd.nextInt(99) + 1;
            szam2 = rnd.nextInt(99) + 1;
        }
        return true;

    }

    private static boolean kivonasEllenorzes(int szam1, int szam2) { // nincs használva
        Random rnd = new Random();
        while ((szam1 - szam2) <= 0) {
            szam1 = rnd.nextInt(99) + 1;
            szam2 = rnd.nextInt(99) + 1;
        }
        return true;
    }

    private static boolean osztasEllenorzes(int szam1, int szam2) { // nincs használva
        Random rnd = new Random();
        while (szam1 % szam2 != 0) {
            szam1 = rnd.nextInt(99) + 1;
            szam2 = rnd.nextInt(99) + 1;
        }
        return true;

    }

    private static String ellenorzesInt(String valasz) {
        Scanner scr = new Scanner(System.in);
        boolean isNumeric = valasz.chars().allMatch(Character::isDigit);
        while (!isNumeric) {
            kiiras("Kérem számot adjon meg: ");
            //System.out.println("Kérem számot adjon meg: ");
            valasz = scr.nextLine();
            isNumeric = valasz.chars().allMatch(Character::isDigit);
        }
        return valasz;
    }

    private static int feladatOsszeAllit(char feladatTipusa) {

//           int szam1 = rndszamGeneralas(feladatTipusa);
//           int szam2 = rndszamGeneralas(feladatTipusa);
        int[] szamTomb = rndszamGeneralas(feladatTipusa);
        int szam1 = szamTomb[0], szam2 = szamTomb[1];
        int vegeredmeny = 0;

        if (feladatTipusa == '+') {
            kiiras(szam1 + "+" + szam2);
            vegeredmeny = szam1 + szam2;
        } else if (feladatTipusa == '-') {
            kiiras(szam1 + "-" + szam2);
            vegeredmeny = szam1 - szam2;
        } else if (feladatTipusa == '*') {
            kiiras(szam1 + "*" + szam2);
            vegeredmeny = szam1 * szam2;
        } else if (feladatTipusa == '/') {
            kiiras(szam1 + "/" + szam2);
            vegeredmeny = szam1 / szam2;
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

    private static int bekerValasz() { //try catchre mert evvel lehet hibára futni
        Scanner scr = new Scanner(System.in);
        kiiras("Kérem adja meg a megoldást: ");
        //System.out.println("Kérem adja meg a megoldást: ");
        String valasz = scr.nextLine();
        valasz = ellenorzesInt(valasz);
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
            if (felhaszValasz != megoldas) {
                rosszMegoldasok[hely] += 1;
                kiiras("Rossz megoldást adott meg!");
                //System.out.println("Rossz megoldást adott meg!");
            } else {
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
            } else if (valasz.equals("n")) {
                jo = true;
                tovabb = false;
            } else {
                kiiras("Rossz adat! Adja meg újra!");
                //System.out.println("Rossz adat! Adja meg újra!");
            }

        } while (!jo);
        return tovabb;
    }

    private static int opHelye(char feladatTipus) {
        int i = 0;
        while (!(feladatTipus == operatorok[i])) {
            i++;
        }
        return i;
    }

    private static int[] rndszamGeneralas(char feladatTipus) {
        Random rnd = new Random();
        int felso = 99;
        int also = 1;
        //Integer[] tomb = new Integer[2];
        int[] tomb = new int[2];
        if (feladatTipus == '+') {
            tomb[0] = rnd.nextInt(felso - also + 1) + also;
            tomb[1] = rnd.nextInt(felso - tomb[0] + 1) + 1;
        } else if (feladatTipus == '-') {
            tomb[0] = rnd.nextInt(felso - also + 1) + also;
            tomb[1] = rnd.nextInt(tomb[0]) + 1; //array sortot majd ki kell adni
            //Arrays.sort(tomb, Comparator.reverseOrder()); // még ez sem az igazi
        } else if (feladatTipus == '*') {
            tomb[0] = rnd.nextInt(felso - also + 1) + also;
            felso = (int) Math.floor(felso / tomb[0]);
            tomb[1] = rnd.nextInt(felso) + 1;
        } else {
            tomb[0] = rnd.nextInt(felso - also + 1) + also;
            ArrayList<Integer> osztok = szamOsztoi(tomb[0]);
            tomb[1] = osztok.get(rnd.nextInt(osztok.size()));
        }
        return tomb;

    }

    static void statisztika() {
        int hossz = operatorok.length;
        kiiras("Feladat típus | feladat DB | elrontott | elrontott % ");
        for (int i = 0; i < hossz; i++) {
            int szazalek = (int) ((100.0 / hanyDBfeladat[i]) * rosszMegoldasok[i]);
            System.out.printf("%13c | %10d | %9d | %11d%%\n", operatorok[i], hanyDBfeladat[i], rosszMegoldasok[i], szazalek);
        }

    }

    private static int maxErtek() { //nem használjuk
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

    private static ArrayList<Integer> szamOsztoi(int szam) {
        ArrayList<Integer> osztok = new ArrayList<>();
        for (int i = 1; i <= szam; i++) {
            if (szam % i == 0) {
                osztok.add(i);
            }
        }
        return osztok;
    }

}
