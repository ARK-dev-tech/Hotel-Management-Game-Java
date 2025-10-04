public class RoomList {
    Register register;
    RoomNode head;
    int roomNum;
    int roomLimit;

    RoomList(int roomLimit, Register register){
        this.roomNum = 1;
        this.roomLimit = roomLimit;
        this.head = null;
        this.register = register;
        for(int i = 1; i <= roomLimit; i++){
            initialize_rooms(i);
        }

    }

    private void initialize_rooms(int roomNum){
        RoomNode newRoom = new RoomNode(new Room(null, roomNum));
        newRoom.room.roomNum = roomNum;

        if(head == null){
            head = newRoom;
        }
        else{
            RoomNode tempRoom = head;
            while(tempRoom.next != null){
                tempRoom = tempRoom.next;
            }
            tempRoom.next = newRoom;
        }
    }

    public int assign_room(Guest guest){
        RoomNode tempRoom = head;
        while(tempRoom != null){
            if(tempRoom.room.guest == null){
                tempRoom.room.guest = guest;
                System.out.println("Guest '" + guest.name + "' added to room number " + tempRoom.room.roomNum + ".");
                register.write_file(guest);
                //money increase
                return 0;
            }
            tempRoom = tempRoom.next;
        }
//        System.out.println("No rooms available!");
//        System.out.println("Guest leaves.");
        //money decrease
        return 1;
    }

    public boolean add_room(int money, int roomCost){
        boolean available = true;
        if(money >= roomCost){
            RoomNode newRoom = new RoomNode(new Room(null, roomNum));
            newRoom.room.roomNum = ++roomLimit;

            RoomNode tempRoom = head;
            while(tempRoom.next != null){
                tempRoom = tempRoom.next;
            }
            tempRoom.next = newRoom;
            System.out.println("Room " + roomLimit + " added.");
        }
        else{

            available = false;
        }
        return available;

    }

    public void display_rooms(){
        RoomNode temp = head;
        while(temp != null){
            System.out.println(temp.room);
            temp = temp.next;
        }
    }

    public void clear_rooms(){
        RoomNode temp = head;
        while(temp != null){
            System.out.println("Guest " + temp.room.guest.name + " is leaving...");
            temp.room.guest = null;
            temp = temp.next;
        }
        System.out.println("All Rooms are now Empty.\n");
    }

}
