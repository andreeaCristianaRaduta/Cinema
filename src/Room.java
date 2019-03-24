public class Room {

    private String roomName;
    private Integer [][] seats;
    private int numberOfSeats = 30;

    public Room(String roomName, Integer[][] seats, Integer numberOfSeats) {
        this.roomName = roomName;
        this.seats = seats;
        this.numberOfSeats = numberOfSeats;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer[][] getSeats() {
        return seats;
    }

    public void setSeats(Integer[][] seats) {
        this.seats = seats;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }


}
