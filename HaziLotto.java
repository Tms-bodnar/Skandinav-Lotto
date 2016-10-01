package hazilotto;

import java.util.Random;
import java.util.Scanner;

public class HaziLotto {

    public static void tombkiir(int[] szamok) {
        for (int i : szamok) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //Gépi számok 1-35 között, ismétlés nélkül
    public static void nyeroszamok(int[] szamok) {
        Random random = new Random();
        for (int i = 0; i < szamok.length; i++) {
            boolean nincsbenne = true;
            int szam = random.nextInt(36) + 1;
            for (int j = 0; j < szamok.length && nincsbenne; j++) {
                if (szam == szamok[j]) {
                    i--;
                    nincsbenne = false;
                }
            }
            if (nincsbenne) {
                szamok[i] = szam;
            }
        }
    }

    //Saját számok 1-35 között ismétlés nélkül (mást nem enged)
    public static void tippadas(int[] szamok) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Csak 1 és 35 közötti számokat adhat meg!");
        for (int i = 0; i < szamok.length; i++) {
            boolean nincsbenne = true;
            System.out.println("Adja meg a(z) " + (i + 1) + ". számot!");
            int szam = sc.nextInt();
            if (szam <= 35 && szam >= 1) {
                for (int j = 0; j < szamok.length && nincsbenne; j++) {
                    if (szam == szamok[j]) {
                        i--;
                        nincsbenne = false;
                        System.out.println("Ezt a számot már megadta egyszer!");
                    }
                }
                if (nincsbenne) {
                    szamok[i] = szam;
                }
            } else {
                System.out.println("Rossz értéket adott meg!");
                i--;
            }

        }
    }
    //találat kereső
    public static void talalatKereso(int[] tomb1, int[] tomb2) {
        int talalat=0;
        for (int i =0; i<tomb2.length;i++) {
            for (int j = 0; j <tomb2.length; j++) {
                if (tomb1[i]==tomb2[j]) {
                    talalat++;
                }
            }
        }
        System.out.println("Önnek "+talalat+" találata volt.");
    }
    private static void rendez(int[] szamok) {
            for (int i = 0; i <szamok.length-1; i++) {
                for (int j = 0; j < szamok.length - 1-i; j++) {
                    if (szamok[j] > szamok[j + 1]) {
                        int temp = szamok[j];
                        szamok[j] = szamok[j + 1];
                        szamok[j + 1] = temp;
                    }
                }
            }
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] gep = new int[7];
        int[] tipp = new int[7];
        System.out.println("Üdvözöljük a 35/7-es lottó sorsolásán!");
        nyeroszamok(gep);

        tippadas(tipp);
        System.out.println("Az Ön nyerőszámai: ");
        rendez(tpp);
        tombkiir(tipp);

        System.out.println("Nyerőszámok: ");
        rendez(gep);
        tombkiir(gep);
        talalatKereso(tipp, gep);

    }

}
