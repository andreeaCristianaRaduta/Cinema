import java.util.Date;

 public class Reservation { ///ne trebuie id la rezervare ca sa existe ceva unic pt PK
    private Date date;
    private Movie movie;
    private Integer numberOfPeople;

    public Reservation(Date date, Movie movie, Integer numberOfPeople) {
        this.date = date;
        this.movie = movie;
        this.numberOfPeople = numberOfPeople;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public void ocupatingSeats(int seats){ //o fac voi ca sa o apelez cand fac o rezervare si sa-mi arunce o rezervare pentru atunci cand nu mai sunt locuri
        while(movie.getRoom().getNumberOfSeats() - movie.getNrOfSeatsOcupated() > -1 && (movie.getRoom().getNumberOfSeats() - movie.getNrOfSeatsOcupated()) >= seats )
            movie.setNrOfSeatsOcupated(movie.getNrOfSeatsOcupated() + seats);// trebuie un ob de tip rezervare de la care sa pot sa iau nr de locuri
    }

    public void makeReservation(){
        Reservation reservation = new Reservation(date, movie, numberOfPeople);
        reservation.ocupatingSeats(numberOfPeople);
    }

 }
