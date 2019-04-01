import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Admin {
    public void addMovie(){
        Scanner sc = new Scanner(System.in); //Nu cred ca e corect sa avem un user cand aadaugam un nou film, dar am pus user susu pt ca
        System.out.println("Introduceti numele filmului:");
        String nume = sc.next();
        System.out.println("Introduceti formatul: twoD/threeD/fourDX/IMAX ");
        //Movie.setFormat(sc.next());


        //adaugam in db                                                     //fiecare utilizator vede din perspectiva lui si primeste pretul in functie de tip
    }
}
