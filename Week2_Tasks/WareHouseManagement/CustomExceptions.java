package WareHouseManagement;
public class CustomExceptions {

    // Exception for Out of Stock
    public static class OutOfStockException extends Exception {
        public OutOfStockException(String message) {
            super(message);
        }
    }

    // Exception for Invalid Location
    public static class InvalidLocationException extends Exception {
        public InvalidLocationException(String message) {
            super(message);
        }
    }

    // Exception for Duplicate Product ID
    public static class DuplicateProductIDException extends Exception {
        public DuplicateProductIDException(String message) {
            super(message);
        }
    }
}
