import java.io.*;
import java.io.BufferedWriter;

public class Register {
    String fileName;
    int index;
    Register(){
        this.fileName = "Register.txt";
        this.index = 1;
        //here check if game is starting again and clear the register using clear_file method
        create_file();
        //creating file when constructor runs, removed need to use file.exists()
    }

    public void create_file(){

        try{
            File register = new File(fileName);
            if(register.createNewFile()){
                System.out.println("File Created: " + register.getName());
            }
            else{
                clear_file();
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

    public void write_file(Guest guest){
        //instead of directly adding into file, add into array then use the index of array for indexing.
        try(BufferedWriter regWrite = new BufferedWriter(new FileWriter(fileName, true))){
            regWrite.write(String.valueOf(index++) + ". " + guest);
            regWrite.newLine();
            //System.out.println("Successfully Added to Register");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void write_file(String[] array){
        clear_file();
        int index2 = 1;
        try(BufferedWriter regWrite = new BufferedWriter(new FileWriter(fileName, true))){
            for(String temp: array){
                regWrite.write(String.valueOf(index2++) + ". " + temp.substring(3));
                regWrite.newLine();
            }
            //System.out.println("Successfully Added to Register");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void clear_file(){
        try(FileWriter clear = new FileWriter(fileName, false)){
            System.out.println(" ");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    public void sort_by_age(){
        BufferedReader reader = null;
        BufferedWriter writer = null;
        DynamicArray tempArray = new DynamicArray();

        try {
            reader = new BufferedReader(new FileReader(fileName));
            String currentLine = reader.readLine();
            while (currentLine != null) {
                tempArray.insert(currentLine);
                currentLine = reader.readLine();
            }
            Sorting.sort_age(tempArray);
//            writer = new BufferedWriter(new FileWriter(filename));
//            for (String temp : tempArray.array) {
//                writer.write(temp);
//                writer.newLine();
//            }
            write_file(tempArray.array);
            //tempArray.print();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //Closing the resources

            try {
                if (reader != null) {
                    reader.close();
                }

                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sort_by_name() {

        BufferedReader reader = null;
        BufferedWriter writer = null;
        DynamicArray tempArray = new DynamicArray();

        try {
            reader = new BufferedReader(new FileReader(fileName));
            String currentLine = reader.readLine();
            while (currentLine != null) {
                tempArray.insert(currentLine);
                currentLine = reader.readLine();
            }
            Sorting.sort_name(tempArray);
//            writer = new BufferedWriter(new FileWriter(filename));
//            for (String temp : tempArray.array) {
//                writer.write(temp);
//                writer.newLine();
//            }
            write_file(tempArray.array);
            //tempArray.print();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //Closing the resources

            try {
                if (reader != null) {
                    reader.close();
                }

                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String search_guest(String searchName){
        boolean found = false;
        String guestFound = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String currentLine = reader.readLine();
            while(currentLine != null){
                if(Sorting.get_field(currentLine, "Name").length() != searchName.length()){
                    currentLine = reader.readLine();
                    continue;
                }
                for(int i = 0; i < searchName.length(); i++){
                    if(searchName.charAt(i) != Sorting.get_field(currentLine, "Name").charAt(i)){
                        found = false;
                        break;
                    }
                    found = true;
                }

                if(found){
                    guestFound = currentLine;
                }

                currentLine = reader.readLine();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return guestFound;
    }

    public boolean is_empty() {
        File file = new File(fileName);
        return file.length() == 0; // Check if the file size is 0 bytes
    }

    public void display(){
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String currentLine = reader.readLine();
            while(currentLine != null){
                System.out.println(currentLine);
                currentLine = reader.readLine();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean validation(){
        boolean valid = true;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String currentLine = reader.readLine();
            while (currentLine != null){
                if(!FieldValidator.is_valid(currentLine)){
                    valid = false;
                    break;
                }
                else{
                    valid = true;
                }

            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return valid;
    }

//    public void verify_guest(){
//        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
//            String currentLine = reader.readLine();
//
//            while(currentLine != null){
//                if(Sorting.get_field(currentLine, "Name") < )
//            }
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//    }
}
