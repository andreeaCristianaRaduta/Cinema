import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

 public class Admin {

     //public void addRoom()

     //public editRoom()

     //public void deleteMovie()

     //public void editMovie()


    public void addMovie(){
        Scanner sc = new Scanner(System.in); //Nu cred ca e corect sa avem un user cand aadaugam un nou film, dar am pus user susu pt ca
        System.out.println("Introduceti numele filmului:");
        String nume = sc.next();
        System.out.println("Introduceti formatul: twoD/threeD/fourDX/IMAX ");
        //Movie.setFormat(sc.next());


        //adaugam in db                                                     //fiecare utilizator vede din perspectiva lui si primeste pretul in functie de tip

    }

     public void ocupatingSeats(int seats){ //o fac voi ca sa o apelez cand fac o rezervare si sa-mi arunce o rezervare pentru atunci cand nu mai sunt locuri
         try{
             while(room.getNumberOfSeats() - nrOfSeatsOcupated > -1){
                 nrOfSeatsOcupated+=reservation.get // trebuie un ob de tip rezervare de la care sa pot sa iau nr de locuri
             }
         }
     }
 }
