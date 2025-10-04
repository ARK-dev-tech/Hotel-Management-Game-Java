public class RadixSort {

    static String[] array = {"Alex", "Jupardy", "Beans", "Holly"};

//    public static void radix_sort(){
//        int maxLength = getMaxStringLength(array);
//
//        for (int pos = maxLength - 1; pos >= 0; pos--) {
//            counting_sort_by_character(array, pos); // Sort by the current position
//        }
//    }



    public static void print(){
        for(String temp: array){
            System.out.print(" "+temp);
        }
    }
}
