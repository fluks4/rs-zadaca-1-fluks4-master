package ba.unsa.etf.rs;

import java.util.Scanner;

public class Zadaca1 {
    public static String najveciGrad(String str){

        String[] redovi = str.split("\\n"); //element niza redovi je jedan red stringa str
        int max = 0;
        for(int i = 0; i < redovi.length; i++)
        {
            String[] posebni = redovi[i].split(","); //element niza posebni je red str od-do zareza, (3 elementa?!)
            if(Integer.parseInt((posebni[2].trim())) > max) //posebni[2] je broj stanovnika (TREBAO BI DA JE?!)
                max = Integer.parseInt((posebni[2]).trim());

        }  //najveći broj stanovnika

        for(int i = 0; i < redovi.length; i++){

            String[] novi = redovi[i].split(",");
            if (Integer.parseInt((novi[2]).trim()) == max) {
                System.out.println(novi[0]); //ispisuje grad koji je prvi element
                return novi[1]; //vraća državu koja je drugi element niza
            }

        }
        return str;
    }

    public static int najvecaSuma (int... br)
    {
        int max = 0;
        int suma = 0;
        int broj, povratni = 0;
        for(int i : br)
        {
            suma = 0;
            broj = i;
            while(broj != 0){
                suma += broj % 10;
                broj /= 10;
            }

            if(suma > max) {
                max = suma;
                povratni = i;
            }
        }
        return povratni;
    }

    public static double[] najmanjaSrednjaVrijednost(double[][] mat){

        double suma = 0;
        double pr1 = 0, pr2 = 0;
        int ind = 0;

        for(int i = 0; i < mat[0].length; i++){
            pr1 += mat[0][i];
        }

        pr1 /= mat[0].length;

        for(int i = 0; i < mat.length; i++)
        {
            suma = 0;
            for(int j = 0; j < mat[i].length; j++)
                suma += mat[i][j];

            pr2 = suma / mat[i].length;

            if(pr2 < pr1)
            {
                pr1 = pr2;
                ind = i;
            }
        }
        return mat[ind];
    }
    public static void main(String[] args) {

        System.out.print("Unesite string sa gradovima (prazan red za kraj): ");
        String gradovi = "";
        Scanner ulaz = new Scanner(System.in);

        do{
            String unos = ulaz.nextLine();

            if(unos.isEmpty())
                break;

            gradovi = gradovi + unos + '\n';
        }
        while(true);

        String drzava = najveciGrad(gradovi);
        System.out.println(drzava);                                                                                // P R V I

        System.out.print("Unesite članove niza cijelih brojeva (0 za kraj): ");
        int[] niz = new int[1000];
        int j = 0;
        while(true)
        {
            niz[j] = ulaz.nextInt();
            if(niz[j] == 0) break;
            j++;
        }
        System.out.println("Broj sa najvećom sumom cifara je: " + najvecaSuma(niz));                         //D R U G I

        int m;
        System.out.print("Unesite broj redova matrice: ");
        m = ulaz.nextInt();
        double[][] mat = new double[m][];
        for(int k = 0; k < m; k++){
            System.out.print("Unesite broj elemenata u " + (k + 1) + ". redu: ");
            int b = 0;
            b = ulaz.nextInt();
            double[] niz3 = new double[b];
            mat[k] = niz3;
            System.out.print("Unesite elemente: ");
            for(int z = 0; z < b; z++){
                mat[k][z] = ulaz.nextDouble();

            }
        }
        double[] niz4 = najmanjaSrednjaVrijednost(mat);
        System.out.println("Red sa najmanjom srednjom vrijednošću glasi:");
        for(int i = 0; i < niz4.length; i++){
            if(niz4[i] - ((int) niz4[i]) == 0)
                System.out.print((int) niz4[i] + " ");
            else
                System.out.print(niz4[i] + " ");
        }                                                                                                   // T R E Ć I
    }
}

