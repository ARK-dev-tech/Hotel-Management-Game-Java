public class StringCompare {

    private static String str1 = "Alex";
    private static String str2 = "Hannah";
    private static boolean isCompare = true;

    public static void compare(){
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                isCompare = false;
            }
        }

        if(isCompare){
            System.out.println("Is equal");
        }
        else{
            System.out.println("Not Equal");
        }

    }

}
