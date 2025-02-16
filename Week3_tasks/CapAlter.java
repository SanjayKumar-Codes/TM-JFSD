package Consolidated_tasks;

public class CapAlter {
    public static void main(String[] args) {
    
        String input = "hello world";

        // Convert and print the result
        String result = capAlterWord(input);
        System.out.println("Original String: " + input);
        System.out.println("Modified String: " + result);
    }

    public static String capAlterWord(String str) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(Character.toLowerCase(ch));
            }
        }
        
        return result.toString();
    }
}

