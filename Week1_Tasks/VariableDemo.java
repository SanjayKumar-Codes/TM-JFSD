public class VariableDemo {
    public static void main(String[] args) {
        int number = 5;
        int[] array = {1, 2, 3};

        modifyVariables(number, array);

        System.out.println("Integer after method: " + number); // Should print 5
        System.out.print("Array after method: ");
        for (int num : array) {
            System.out.print(num + " "); // Should print modified array
        }
    }

    public static void modifyVariables(int num, int[] arr) {
        num += 10; // This won't affect the original integer
        arr[0] += 10; // This will affect the original array
    }
}