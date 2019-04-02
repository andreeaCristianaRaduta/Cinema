import java.util.Date;

public class Movie { //un film trebuie sa aiba o data si o ora
    private User user;
    private String name;
    private Double price;
    public format aFormat;
    private Date date;
    private Room room;
    private Integer id;
    private Integer nrOfSeatsOcupated = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNrOfSeatsOcupated() {
        return nrOfSeatsOcupated;
    }

    public void setNrOfSeatsOcupated(Integer nrOfSeatsOcupated) {
        this.nrOfSeatsOcupated = nrOfSeatsOcupated;
    }

    private enum format{
         twoD , three, IMAX, fourDX;
    }

    public Movie( String name, format aFormat, Double price, Date date, Room room) { //pot sa nu-i dau eu id? sa si puna sg in baza de date??
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



}
