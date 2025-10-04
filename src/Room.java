public class Room {
    Guest guest;
    int roomNum;

    Room(Guest guest, int roomNum){
        this.guest = guest;
        this.roomNum = roomNum;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNum + ", Guest: " + (guest != null ? guest : "None");
    }
}
