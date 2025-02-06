package UniversityLibrary;

// Custom exception for when a book is not found
class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}

// Custom exception for when a user is not found
class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

// Custom exception for when a user borrows too many books
class MaxBooksAllowedException extends Exception {
    public MaxBooksAllowedException(String message) {
        super(message);
    }
}
