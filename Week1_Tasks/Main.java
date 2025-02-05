public class Main {
    public static void main(String[] args) {
        // Test all methods
        String test = "hello world";
        
        // Test reverse
        System.out.println("Reversed: " + reverse(test));
        
        // Test count
        System.out.println("Count of 'l': " + count(test, "l"));
        
        // Test capitalize
        System.out.println("Capitalized: " + capitalize(test));
    }
    
    static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    static int count(String text, String sub) {
        return text.length() - text.replace(sub, "").length();
    }
    
    static String capitalize(String str) {
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
        }
        return String.join(" ", words);
    }
}