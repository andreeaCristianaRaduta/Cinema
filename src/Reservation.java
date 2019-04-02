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

    public void makeReservation(){
        Reservation reservation = new Reservation(date, movie, numberOfPeople);
        movie.getRoom().setNumberOfSeats(movie.getRoom().getNumberOfSeats()- numberOfPeople);
    }

}
