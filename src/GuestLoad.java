public class GuestLoad {
    DynamicArray guestLoadArray;
    GuestLoad(){
        guestLoadArray = new DynamicArray();

        guestLoadArray.insert(new Guest("Eve", 22, "India", "2024-12-29", 0));
        guestLoadArray.insert(new Guest("Adam", 45, "USA", "2025-01-15", 0));
        guestLoadArray.insert(new Guest("Liam", 56, "Can3da", "2025-02-10", 0));
        guestLoadArray.insert(new Guest("Emma", 28, "Australia", "2024-12-31", 0));
        guestLoadArray.insert(new Guest("Noah", -35, "UK", "2025-03-12", 0));
        guestLoadArray.insert(new Guest("0livia", 33, "Germany", "2024-12-29", 0));
        guestLoadArray.insert(new Guest("Lucas", 29, "France", "2025-01-20", 0));
        guestLoadArray.insert(new Guest("Ava", 42, "Italy", "2025-02-15", 0));
        guestLoadArray.insert(new Guest("Ethan", 27, "Spain", "202-412-30", 0));
        guestLoadArray.insert(new Guest("Sophia", 23, "Braz1l", "2025-03-05", 0));
        guestLoadArray.insert(new Guest("James", 48, "Japan", "2025-01-25", 0));
        guestLoadArray.insert(new Guest("Isabella", 26, "China", "2024-12-28", 0));
        guestLoadArray.insert(new Guest("William", 34, "India", "2025-02-18", 0));
        guestLoadArray.insert(new Guest("Mia", 22, "USA", "2025-03-10", 0));
        guestLoadArray.insert(new Guest("Benjamin", 51, "Canada", "2024-12-29", 0));
        guestLoadArray.insert(new Guest("Charlotte", 31, "Australia", "2025-01-30", 0));
        guestLoadArray.insert(new Guest("Henry", 38, "UK", "2025-02-12", 0));
        guestLoadArray.insert(new Guest("Amelia", 25, "Germany", "2024-12-31", 0));
        guestLoadArray.insert(new Guest("Alexander", 27, "France", "2025-03-02", 0));
        guestLoadArray.insert(new Guest("Harper", 40, "Italy", "2-2501-10", 0));
        guestLoadArray.insert(new Guest("Sebastian", 45, "Spain", "2024-12-30", 0));
        guestLoadArray.insert(new Guest("Evelyn", 60, "Brazil", "2025-02-25", 0));
        guestLoadArray.insert(new Guest("M1chael", 36, "Japan", "2024-12-29", 0));
        guestLoadArray.insert(new Guest("Abigail", 32, "China", "2025-03-18", 0));
        guestLoadArray.insert(new Guest("Daniel", 26, "India", "2024-12-28", 0));
        guestLoadArray.insert(new Guest("Emily", 23, "USA", "2025-01-22", 0));
        guestLoadArray.insert(new Guest("Logan", 31, "Canada", "2025-02-14", 0));
        guestLoadArray.insert(new Guest("Elizabeth", 34, "Australia", "2024-1-231", 0));
        guestLoadArray.insert(new Guest("Jackson", 38, "UK", "2025-03-20", 0));
        guestLoadArray.insert(new Guest("Avery", 25, "Germany", "2024-12-30", 0));
        guestLoadArray.insert(new Guest("Ai7en", 47, "France", "2025-01-18", 0));
        guestLoadArray.insert(new Guest("Sofia", -22, "Italy", "2025-02-10", 0));
        guestLoadArray.insert(new Guest("Ma2thew", 33, "Spain", "2024-12-29", 0));
        guestLoadArray.insert(new Guest("Chloe", 29, "Brazil", "2025-03-08", 0));
        guestLoadArray.insert(new Guest("David", 30, "Japan", "2024-12-28", 0));
        guestLoadArray.insert(new Guest("Grace", 26, "China", "2025-01-12", 0));
        guestLoadArray.insert(new Guest("Joseph", 24, "I4dia", "2024-12-31", 0));
        guestLoadArray.insert(new Guest("Hannah", -52, "USA", "2025-02-20", 0));
        guestLoadArray.insert(new Guest("Samuel", 27, "Canada", "2024-12-29", 0));
        guestLoadArray.insert(new Guest("Zoey", 25, "Australia", "2025-03-02", 0));
        guestLoadArray.insert(new Guest("Owen", 35, "UK", "2025-011-", 0));
        guestLoadArray.insert(new Guest("Victoria", 41, "Germany", "2024-12-30", 0));
        guestLoadArray.insert(new Guest("E1ijah", 28, "France", "2025-02-15", 0));
        guestLoadArray.insert(new Guest("Layla", 23, "Italy", "2025-01-22", 0));
        guestLoadArray.insert(new Guest("Carter", 34, "Sp2in", "2024-12-31", 0));
        guestLoadArray.insert(new Guest("Lillian", 50, "Brazil", "2025-03-12", 0));
        guestLoadArray.insert(new Guest("Jayden", 32, "Japan", "2024-12-29", 0));
        guestLoadArray.insert(new Guest("Aubrey", 24, "Chi0a", "2025-01-10", 0));
        guestLoadArray.insert(new Guest("Gabriel", 29, "India", "2024-12-28", 0));
        guestLoadArray.insert(new Guest("Aria", 27, "USA", "2025-02-28", 0));

    }

    public DynamicArray getGuestArray() {
        return guestLoadArray;
    }
}
