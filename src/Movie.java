import java.util.Date;

public class Movie {
    private User user;
    private String name;
    private Double price;
    public format aFormat;
    private Date date;
    private Room room;

    enum format{
        twoD, threeD, IMAX, fourDX;
    }

    public Movie( String name, format aFormat, Double price, Date date, Room room) {
        this.name = name;
        this.aFormat = aFormat;
        this.price = price;
        this.date = date;
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public format getFormat() {
        return aFormat;
    }

    public void setFormat(format aFormat) {
        this.aFormat = aFormat;
    }

    public Double getPrice() {
        if( user.getType() == User.type.child )
            return price - 0.5*price;

        else if( user.getType() == User.type.student )
            return price - 0.25*price;

        else if( user.getType() == User.type.elder )
            return price - 0.30*price;

        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void addMovie(){
        Movie movie = new Movie( name, aFormat, price,date, room); //Nu cred ca e corect sa avem un user cand aadaugam un nou film, dar am pus user susu pt ca
        //adaugam in db                                                     //fiecare utilizator vede din perspectiva lui si primeste pretul in functie de tip
    }

}
