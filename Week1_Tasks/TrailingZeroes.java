public class TrailingZeroes {
    public static void main(String[] args) {
        int number = 100;
        int trailingZeroes = countTrailingZeroes(number);
        System.out.println("Trailing zeroes in " + number + "! : " + trailingZeroes);
    }

    public static int countTrailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }
}