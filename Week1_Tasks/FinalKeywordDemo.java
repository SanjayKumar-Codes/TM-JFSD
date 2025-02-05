final class FinalClass {
    final int finalVariable = 10;

    final void finalMethod() {
        System.out.println("This is a final method.");
    }
}

// Uncommenting the following line will cause a compilation error
// class SubClass extends FinalClass {}

public class FinalKeywordDemo {
    public static void main(String[] args) {
        FinalClass finalClass = new FinalClass();
        System.out.println("Final Variable: " + finalClass.finalVariable);
        finalClass.finalMethod();
    }
}