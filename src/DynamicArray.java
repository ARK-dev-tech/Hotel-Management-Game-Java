public class DynamicArray {

    String[] array;
    Guest[] guestDynamicArray;
    //int number;
    int index;

    DynamicArray(){
        this.index = 0;
        this.array = new String[1];
        this.guestDynamicArray = new Guest[10];
    }

//    DynamicArray(Guest guest){
//        this.index = 0;
//        this.number = guest.age;
//    }

    public void insert(String data){

        if(index == array.length){
            String[] temp = new String[array.length + 1];
            for(int i = 0; i < array.length; i++){
                temp[i] = array[i];
            }
            array = temp;
        }

        array[index] = data;
        index++;
    }

    public void insert(Guest guest){

        if(index == guestDynamicArray.length){
            Guest[] temp = new Guest[guestDynamicArray.length + 5];
            for(int i = 0; i < guestDynamicArray.length; i++){
                temp[i] = guestDynamicArray[i];
            }
            guestDynamicArray = temp;
        }

        guestDynamicArray[index] = guest;
        index++;
    }

    public void print(){
        if(index > 0){
            System.out.println("\nPrinting Dynamic Array content:");
            for(String temp: array){
                System.out.println(temp);
            }
            System.out.println();
        }
        else{
            System.out.println("Empty Array.");
        }
    }
    public void print_guest(){
        if(index > 0){
            System.out.println("\nPrinting Dynamic Array content:");
            for(Guest temp: guestDynamicArray){
                System.out.println(temp);
            }
            System.out.println();
        }
        else{
            System.out.println("Empty Array.");
        }
    }
}
