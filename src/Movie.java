import java.util.Date;

public class Movie { //un film trebuie sa aiba o data si o ora
    private User user;
    private String name;
    private Double price;
    public String format;
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


    public Movie(Integer id,  String name,  Double price, String aFormat, Date date, Room room) { //pot sa nu-i dau eu id? sa si puna sg in baza de date??
        this.id=id;
        this.name = name;
        this.format = aFormat;
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

    public String getFormat() {
        return format;
    }

    public void setFormat(String aFormat) {
        this.format = aFormat;
    }

    public Double getPrice() {
        if( user.isChild() == true )
            return price - 0.5*price;

        else if( user.isStudent() == true )
            return price - 0.25*price;

        else if( user.isElder() == true )
            return price - 0.30*price;

        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



}
