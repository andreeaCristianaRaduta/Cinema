package main;
import java.util.ArrayList;
import java.util.Date;

public class Reservation { ///ne trebuie id la rezervare ca sa existe ceva unic pt PK

    private Movie movie;
    private int idUser;


    public Reservation(Movie mv) {
    }

    public Reservation( Movie movie, int idUser) {
        this.movie = movie;
        this.idUser=idUser;
    }


    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "movie=" + movie +
                ", idUser=" + idUser +
                '}' + "\n";
    }
//    public void ocupatingSeats(int seats) { //o fac voi ca sa o apelez cand fac o rezervare si sa-mi arunce o rezervare pentru atunci cand nu mai sunt locuri
//        while (movie.getRoom().getNumberOfSeats() - movie.getNrOfSeatsOcupated() > -1 && (movie.getRoom().getNumberOfSeats() - movie.getNrOfSeatsOcupated()) >= seats) {
//            movie.setNrOfSeatsOcupated(movie.getNrOfSeatsOcupated() + seats);// trebuie un ob de tip rezervare de la care sa pot sa iau nr de locuri
//        }
//    }



}
