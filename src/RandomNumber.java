public class RandomNumber {

    public static int generate_random_number(int range) {
        // Generates a random number from 0 (inclusive) to range (exclusive)
        return (int) (Math.random() * range);
    }

}