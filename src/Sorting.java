public class Sorting {

//    public static void sort_name(DynamicArray dynamicArray){
//        System.out.println("Sorting by Name:");
//
//        //BUBBLE SORT
//        String[] name = dynamicArray.array;
//        int count = name.length;
//        for (int i = 0; i < count - 1; i++) {
//            for (int j = 0; j < count - i - 1; j++) {
//                String name1 = get_field(name[j], "Name");
//                String name2 = get_field(name[j + 1], "Name");
//
//                if (compare(name1, name2) > 0) {
//                    // Swap
//                    String temp = name[j];
//                    name[j] = name[j + 1];
//                    name[j + 1] = temp;
//                }
//            }
//        }
//
//    }

    public static void sort_name(DynamicArray dynamicArray) {
        System.out.println("Sorting by Name:");

        // Radix Sort for Name
        String[] entries = dynamicArray.array;
        int count = entries.length;
        int maxLen = get_max_length(entries);

        //Sorting each character position starting from the least significant
        for (int digit = maxLen - 1; digit >= 0; digit--) {
            counting_name_sort_by_digit(entries, count, digit);
        }
    }

    public static void sort_age(DynamicArray dynamicArray) {
        System.out.println("Sorting by Age:");

        // Radix Sort for age
        String[] entries = dynamicArray.array;
        int count = entries.length;
        int maxLen = get_max_length(entries);


        for (int digit = maxLen - 1; digit >= 0; digit--) {
            counting_age_sort_by_digit(entries, count, digit);
        }
    }

    // Radix Sort
    public static void counting_name_sort_by_digit(String[] array, int count, int digit){
        //counting array
        String[] output = new String[count];
        int[] countArray = new int[256]; //ASCII characters range (0-255)

        //Count of each character at the digit position
        for (int i = 0; i < count; i++){
            String name = get_field(array[i], "Name");
            int charIndex = get_char_at(name, digit);
            countArray[charIndex]++;
        }
        for (int i = 1; i < 256; i++){
            countArray[i] += countArray[i - 1];
        }

        for (int i = count - 1; i >= 0; i--){
            String name = get_field(array[i], "Name");
            int charIndex = get_char_at(name, digit);
            output[countArray[charIndex] - 1] = array[i];
            countArray[charIndex]--;
        }


        System.arraycopy(output, 0, array, 0, count);
    }

    public static void counting_age_sort_by_digit(String[] array, int count, int digit){

        String[] output = new String[count];
        int[] countArray = new int[256]; // ASCII characters range (0-255)


        for (int i = 0; i < count; i++){
            String age = get_field(array[i], "Age");
            int charIndex = get_char_at(age, digit);
            countArray[charIndex]++;
        }


        for (int i = 1; i < 256; i++){
            countArray[i] += countArray[i - 1];
        }


        for (int i = count - 1; i >= 0; i--) {
            String age = get_field(array[i], "Age");
            int charIndex = get_char_at(age, digit);
            output[countArray[charIndex] - 1] = array[i];
            countArray[charIndex]--;
        }


        System.arraycopy(output, 0, array, 0, count);
    }



    //helper function to get the character at a specific digit position
    public static int get_char_at(String str, int index){
        if (index >= str.length()) {
            return 0;
        }
        return str.charAt(index);
    }

    //helper funtion to get the max string length in the array
    public static int get_max_length(String[] array) {
        int maxLen = 0;
        for (String str : array){
            String name = get_field(str, "Name");
            maxLen = Math.max(maxLen, name.length());
        }
        return maxLen;
    }





//    public static void sort_age(DynamicArray dynamicArray){
    //BUBBLE SORT
//        System.out.println("Sorting by Age:");
//        String[] age = dynamicArray.array;
//        int count = age.length;
//        for (int i = 0; i < count - 1; i++) {
//            for (int j = 0; j < count - i - 1; j++) {
//                String age1 = get_field(age[j], "Age");
//                String age2 = get_field(age[j + 1], "Age");
//
//                if (compare(age1, age2) > 0) {
//                    // Swap
//                    String temp = age[j];
//                    age[j] = age[j + 1];
//                    age[j + 1] = temp;
//                }
//            }
//        }
//    }

    public static int compare(String s1, String s2) {
        int length = Math.min(s1.length(), s2.length());
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) - s2.charAt(i);
            }
        }
        return s1.length() - s2.length();
    }


    //extract the 'Name' field value from the entry string
    public static String get_field(String entry, String fieldName) {
        int start = entry.indexOf(fieldName + ": '") + fieldName.length() + 3;
        int end = entry.indexOf("'", start);
        return entry.substring(start, end);
    }
}
