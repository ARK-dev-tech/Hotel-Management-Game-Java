import java.util.Scanner;

public class GameManager {
    int day; // to count how many days
    int money;
    int option; //input store
    int count; //helper
    int guestCounter; //how many guest
    int stayCounter; //how many stayed for 1 day
    int totalStayCounter; // total, example 3 days total //
    int rejectedGuest; // how many rejected
    int upsetGuest; // how many guests left because of no more rooms
    int roomCost; // how much cost to add one room
    int stayCost; // price of staying in hotel
    int totalDays; // how many days game will run
    int availableRooms; // how many empty room/available rooms
    boolean gameStatus; // helper, stores game win or lose
    String searchName; // helper, officer will use this to say what name to search
    GuestQueue guestQueue; //not used

    GameManager(){
        this.day = 1; //game will not start from day 0
        this.money = 0;
        this.count = 2; //described below
        this.roomCost = 20;
        this.stayCost = 10;
        this.totalDays = 2;
        this.guestCounter = 0;
        this.stayCounter = 0;
        this.totalStayCounter = 0;
        this.rejectedGuest = 0;
        this.upsetGuest = 0;
        //this.guestQueue = queue;
        this.searchName = "Eve";
    }



    public void run_game() {
        Scanner input = new Scanner(System.in);

        //loop label
        mainMenuLoop:
        while (true) {
            System.out.println("=========================================");
            System.out.println("             HOTEL MANAGEMENT");
            System.out.println("                 MAIN MENU");
            System.out.println("=========================================");
            System.out.println("1. Start Game");
            System.out.println("2. Exit");
            System.out.print("Select an option: ");
            option = input.nextInt();

            if (option == 1) {
                GuestQueue guestQueue = new GuestQueue();
                Register newRegister = new Register();
                RoomList list1 = new RoomList(4, newRegister);

                guestQueue.guest_load(); //load already at day 1
                availableRooms = list1.roomLimit; //how many rooms, default 4
                System.out.println("\n=========================================");
                System.out.println("                  HOW TO PLAY");
                System.out.println("=========================================");
                System.out.println("Check the ID fields of every guest and reject guest with invalid fields");
                System.out.println("Correct ID should be in this Format:");
                System.out.println("          *GUEST ID*\n" +
                        "-----------------------------------------\n" +
                        "Name:    Sarah" + "\n" +
                        "Age:     24" + "\n" +
                        "Country: Pakistan" + "\n" +
                        "Expiry:  2030-08-17" + "\n" +
                        "-----------------------------------------");
                System.out.println("Also keep an eye on the number of rooms you have available");
                System.out.println("Giving a room to a guest when there are no empty rooms will make the guest leave upset,");
                System.out.println("and you will lose money for ruining the Hotel's reputation.");
                System.out.println("Game will run for " + totalDays + " days.");
                System.out.println("At the end of the last day an officer will come to check your register.");
                System.out.println("Letting people with false ID's stay is a major crime here, so make sure to reject those guests.");
                System.out.println("Good Luck :D");
                System.out.println("\nGame Starting...");
                System.out.println("...");
                System.out.println("...");
                System.out.println("...");
                System.out.println("...");
                System.out.println("...");
                System.out.println("...");
                repeatingDayLoop:
                while (day <= totalDays) {  // run till total days which is 2 right now

                    //make function to queue guest each day, example load queue
                    if(day == count){ //day 2 == count 2 (
                        System.out.print("*test* loading queue again, count value: " + count + ", day value: " + day);
                        guestQueue.guest_load(); //loads new guests each day
                        count++; //make count 4
                        availableRooms = list1.roomLimit;
                        System.out.println(", new count: " + count + "\n");
                    }

                    System.out.println("\n=========================================");
                    System.out.println("                  DAY " + day);
                    System.out.println("=========================================");
                    System.out.println("Guest Enters...");
                    guestCounter++;
                    System.out.println("\n\"Hello, Welcome to Classy Hotel. What is your name?\"");
                    System.out.println("Guest: \"My name is " + guestQueue.front.guest.name + "\"");
                    System.out.println("\"Show me your ID please.\"");
                    System.out.println("\n=========================================");
                    System.out.println("          *GUEST ID*\n" +
                            "-----------------------------------------\n" +
                            "Name:    " + guestQueue.front.guest.name + "\n" +
                            "Age:     " + guestQueue.front.guest.age + "\n" +
                            "Country: " + guestQueue.front.guest.country + "\n" +
                            "Expiry:  " + guestQueue.front.guest.expiry + "\n" +
                            "-----------------------------------------");

                    currentGuestLoop:
                    while (true) {
                        System.out.println("\n=========================================");
                        System.out.println("             CURRENT STATUS");
                        System.out.println("=========================================");
                        System.out.println("Total Rooms: " + list1.roomLimit);
                        System.out.println("Available Empty Rooms: " + availableRooms);
                        System.out.println("No. of Guests Staying Currently: " + stayCounter); //0
                        System.out.println("Money: $" + money); //0
                        System.out.println("=========================================");
                        System.out.println("1. Assign Room"); //day 2 second guest
                        System.out.println("2. Reject Guest");
                        System.out.println("3. Open Register");
                        System.out.println("4. Add a Room ($20)");
                        System.out.print("Select an option: ");
                        option = input.nextInt();

                        switch (option) {
                            case 1: { //GIVE ROOM TO GUEST

                                System.out.println("\nAssigning a room...");
                                guestQueue.front.guest.dayEnter = day; //set which day this guest arrives, 1
                                int ifStay = list1.assign_room(guestQueue.dequeue());
                                if(ifStay == 1){ //NO MORE ROOMS GUEST LEAVES UPSET
                                    upsetGuest++;
                                    System.out.println("No more Rooms!\nGuest Leaves upset...");
                                    System.out.println("Money decreased: -$" + (stayCost + 20));
                                    money -= stayCost + 20;
                                    if (money < 0) money = 0; // Prevent negative money
                                }
                                else{ //ROOM AVAILABLE AND ASSIGNED
                                    totalStayCounter++; //+1
                                    stayCounter++; //+1 resets each day
                                    availableRooms--;
                                    money += stayCost;
                                    System.out.println("Money added: $" + stayCost);
                                }
                                break currentGuestLoop;
                            }
                            case 2: { //REJECT GUEST
                                rejectedGuest++;
                                System.out.println("\nRejected guest " + guestQueue.front.guest.name);
                                guestQueue.dequeue();
                                break currentGuestLoop;
                            }
                            case 3: { //OPEN REGISTER
                                System.out.println("\n=========================================");
                                System.out.println("                 REGISTER");
                                System.out.println("=========================================");

                                if (newRegister.is_empty()) { //Check if no guest have stayed yet //day 2 second guest
                                    System.out.println("The register is currently empty. No guests have been assigned rooms yet.");
                                } else {
                                    newRegister.display(); // Displays the file contents

                                    registerLoop:
                                    while(true){ //REGISTER MENU (SORTING)
                                        System.out.println("1. Sort Register by Name.");
                                        System.out.println("2. Sort Register by Age.");
                                        System.out.println("3. Exit Register.");
                                        System.out.print("Select an option: ");

                                        int regOption = input.nextInt();
                                        switch (regOption){
                                            case 1: {
                                                newRegister.sort_by_name();
                                                System.out.println("=========================================\n");
                                                newRegister.display();
                                                System.out.println("\n=========================================");
                                            } break;
                                            case 2: {
                                                newRegister.sort_by_age();
                                                System.out.println("=========================================\n");
                                                newRegister.display();
                                                System.out.println("\n=========================================");
                                            } break;
                                            case 3: {
                                                break registerLoop;
                                            }
                                            default: {
                                                System.out.println("Invalid option. Please try again.");
                                            }
                                        }
                                    }
                                }

                                System.out.println("=========================================");
                            } break;
                            case 4: { //ADD ROOMS
                                System.out.println("\nAdding a room...");
                                //If room added, return true, if not enough money so return false and do not increase available rooms.
                                if(list1.add_room(money, roomCost)) { //if not enough money do not increase available rooms, need return
                                    availableRooms++;
                                    money -= roomCost;
                                    //if (money < 0) money = 0;  // Prevent negative money
                                    System.out.println("Room added. Money remaining: $" + money);
                                }
                                else{
                                    System.out.println("Not enough Money");
                                }


                            } break;
                            default: {
                                System.out.println("Invalid option. Please try again.");
                            }
                        }
                    }


                    //OFFICER ARRIVES CHECK
                    if (guestQueue.is_empty() && day == totalDays) { //check last day end 2  2
                        System.out.println("\n=========================================");
                        System.out.println("             DAY ENDED");
                        System.out.println("=========================================");
                        System.out.println("\nGUESTS ARE LEAVING");
                        list1.clear_rooms();
                        System.out.println("\n=========================================");
                        System.out.println("              OFFICER ARRIVES");
                        System.out.println("=========================================");
                        System.out.println("Officer: Hello, I am an officer from the nearby Police Station.\n" +
                                "Has " + searchName + " stayed here?");
                        String searched = newRegister.search_guest(searchName);
                        if (searched != null) {
                            System.out.println("\nGuest Found!");
                            System.out.println("Here is the information about the guest:");
                            System.out.println(searched);
                        } else {
                            System.out.println("\n" + searchName + " did not stay here.");
                        }

                        System.out.println("\nFollowing the government policy, I will check your register for false IDs...");
                        System.out.println("*Checking Register for any Invalid ID's*");
                        System.out.println("...");
                        System.out.println("...");
                        System.out.println("...");
                        System.out.println("...");
                        System.out.println("...");
                        System.out.println("...");
                        //boolean valid = true; // Test
                        if (newRegister.validation()) {

                            gameStatus = true;
                            System.out.println("Congratulations! Everything seems to be in order.");
                            System.out.println("You receive $100,000 from the government for good behavior!");

                            System.out.println("\n=========================================");
                            System.out.println("             GAME WON!");
                            System.out.println("=========================================");

                            break;
                        } else{
                            gameStatus = false;
                            System.out.println("You let people with false IDs stay here. You are under arrest!");
                            System.out.println("\n=========================================");
                            System.out.println("             GAME OVER!");
                            System.out.println("=========================================");

                            break;
                        }
                    }
                    //DAY 2
                    //DAY END CHECK
                    else if(guestQueue.is_empty()) {
                        System.out.println("\n=========================================");
                        System.out.println("             DAY ENDED");
                        System.out.println("=========================================");
                        System.out.println("\nGUESTS ARE LEAVING");
                        list1.clear_rooms();
                        day++; //DAY 2
                        stayCounter = 0;
                        System.out.println("\n=========================================");
                        System.out.println("             NEW DAY STARTING");
                        System.out.println("=========================================");
                    }
                }
                day = 1; //reset day

                System.out.println("\n=========================================");
                System.out.println("          GAME SUMMARY");
                System.out.println("=========================================\n");
                System.out.println("Total Guests Received: " + guestCounter);
                System.out.println("Total Guests Stayed: " + totalStayCounter);
                System.out.println("Guest that were Rejected: " + rejectedGuest);
                System.out.println("Guest that left Upset: " + upsetGuest);
                System.out.println("Total Money Earned: $" + money);
                if(gameStatus){
                    System.out.println("Game was Won");
                }
                else{
                    System.out.println("Game was Lost");
                }
                System.out.println("\n=========================================");
                System.out.println("          FINAL REGISTER");
                System.out.println("=========================================\n");
                newRegister.sort_by_name();
                newRegister.display();
                System.out.println("\n=========================================");
                System.out.println("\n   *** THANK YOU FOR PLAYING THE GAME ***\n\n\n");

            }
            else {
                System.out.println("\n=========================================");
                System.out.println("               GOODBYE!");
                System.out.println("=========================================");
                break;
            }

        }
    }



}
