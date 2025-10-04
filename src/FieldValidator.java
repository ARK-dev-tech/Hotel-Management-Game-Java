public class FieldValidator {

    // Method to check if the string contains only letters (for Name)
    public static boolean is_only_letters(String value) {
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c < 'A' || (c > 'Z' && c < 'a') || c > 'z') {
                return false;
            }
        }
        return true;
    }

    // Method to check if the string contains only digits (for Age and Day)
    public static boolean is_only_digits(String value) {
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    // Method to check if the date string is in the format yyyy-MM-dd
    public static boolean is_valid_date(String value) {
        if (value.length() != 10) return false;
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (i == 4 || i == 7) {
                if (c != '-') return false; // Hyphen should be at position 4 and 7
            } else if (c < '0' || c > '9') {
                return false; // Only digits allowed
            }
        }
        return true;
    }

    // Method to validate the fields in the input string
    public static boolean is_valid(String line) {
        //String line = input.toString();
        // Remove curly braces and split by commas
        String[] fields = line.replace("{", "").replace("}", "").split(", ");

        // Check each field
        for (String field : fields) {
            String[] keyValue = field.split(": ");
            String key = keyValue[0].trim();
            String value = keyValue[1].trim().replace("'", "");

            switch (key) {
                case "Name":
                    if (value.isEmpty() || !is_only_letters(value)) {
                        return false; // Name must contain only letters
                    }
                    break;

                case "Age":
                    if (!is_only_digits(value)) {
                        return false; // Age should be a valid integer (digits only)
                    }
                    int age = 0;
                    for (int i = 0; i < value.length(); i++) {
                        age = age * 10 + (value.charAt(i) - '0'); // Convert string to integer manually
                    }
                    if (age <= 0) {
                        return false; // Age should be positive
                    }
                    break;

                case "Country":
                    for (int i = 0; i < value.length(); i++) {
                        if (value.charAt(i) >= '0' && value.charAt(i) <= '9') {
                            return false; // Country should not contain numbers
                        }
                    }
                    break;

                case "Expiry":
                    if (!is_valid_date(value)) {
                        return false; // Invalid date format
                    }
                    break;

                case "Day":
                    if (!is_only_digits(value)) {
                        return false; // Day should be a valid integer (digits only)
                    }
                    int day = 0;
                    for (int i = 0; i < value.length(); i++) {
                        day = day * 10 + (value.charAt(i) - '0'); // Convert string to integer manually
                    }
                    if (day < 1 || day > 7) {
                        return false; // Day should be between 1 and 7
                    }
                    break;

                default:
                    return false; // Unknown key
            }
        }
        return true; // All fields are valid
    }
}
