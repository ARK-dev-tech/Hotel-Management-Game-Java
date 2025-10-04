public class GuestQueue {

    GuestNode front, rear;
    //int size, capacity;

    GuestQueue(){
        this.front = null;
        this.rear = null;
        //this.size = 0;
    }

    public boolean is_empty(){
        return (front == null);
    }

    public void enqueue(Guest guest){
        GuestNode newGuest = new GuestNode(guest);

        if(rear == null){
            front = newGuest;
            rear = newGuest;
        }
        else{
            rear.next = newGuest;
            rear = newGuest;
        }
//        System.out.println("Loaded");
//        System.out.println(guest);
        //size++
    }

    public Guest dequeue(){
        if(is_empty()){
            System.out.println("Queue is Empty!");
            return null;
        }
        Guest tempGuest = front.guest;
        front = front.next;
        if(front == null){
            rear = null;
        }
        //size--
        return tempGuest;
    }

    public Guest peek(){
        if(is_empty()){
            return null;
        }
        return front.guest;
    }

    public void print_queue(){
        if(is_empty()){
            System.out.println("Queue is empty!");
            return;
        }

        GuestNode tempGuest = front;
        while(tempGuest != null){
            System.out.println(tempGuest.guest);
            tempGuest = tempGuest.next;
        }
    }

    public void guest_load(){
        GuestLoad newQueue = new GuestLoad();
        int index = RandomNumber.generate_random_number(newQueue.guestLoadArray.guestDynamicArray.length - 6);
        //System.out.println("random number: " + index);
        for(int i = index; i < index + 5; i++){
            enqueue(newQueue.guestLoadArray.guestDynamicArray[i]);
        }
    }




}
