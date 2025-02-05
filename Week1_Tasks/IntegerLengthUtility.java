public class IntegerLengthUtility {
    
    // Utility method to find length of integer
    public static int findIntegerLength(int number) {
        // Handle special case for 0
        if (number == 0) {
            return 1;
        }
        
        // Use absolute value to handle negative numbers
        number = Math.abs(number);
        
        // Initialize length counter
        int length = 0;
        
        // Count digits by division
        while (number > 0) {
            length++;
            number /= 10;
        }
        
        return length;
    }
    
    // Main method for demonstration
    public static void main(String[] args) {
        // Test cases
        int[] testNumbers = {0, 42, -123, 1000, -9999};
        
        // Print length for each test number
        for (int num : testNumbers) {
            System.out.println("Length of " + num + " is: " + findIntegerLength(num));
        }
    }
}