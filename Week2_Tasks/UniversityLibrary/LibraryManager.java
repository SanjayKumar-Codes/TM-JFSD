package UniversityLibrary;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager extends LibrarySystem {
    private static final int MAX_BORROW_LIMIT = 3; // Maximum books a user can borrow

    // Constructor initializes book and user lists
    public LibraryManager() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Adds a new book to the library
    @Override
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getBookTitle());
    }

    // Adds a new user to the library
    @Override
    public void addUser(Users user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    // User borrows a book
    @Override
    public synchronized void borrowBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException, MaxBooksAllowedException {
        Users user = findUser(userID);
        Book book = findBook(ISBN);

        if (user.getBorrowedBooks().size() >= MAX_BORROW_LIMIT) {
            throw new MaxBooksAllowedException("User has already borrowed the maximum number of books.");
        }

        user.getBorrowedBooks().add(book);
        books.remove(book);
        System.out.println(user.getName() + " borrowed " + book.getBookTitle());
    }

    // User returns a book
    @Override
    public synchronized void returnBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException {
        Users user = findUser(userID);
        Book book = findBook(ISBN);

        if (!user.getBorrowedBooks().contains(book)) {
            throw new BookNotFoundException("This book was not borrowed by the user.");
        }

        user.getBorrowedBooks().remove(book);
        books.add(book);
        System.out.println(user.getName() + " returned " + book.getBookTitle());
    }

    // User reserves a book
    @Override
    public void reserveBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException {
        Users user = findUser(userID);
        Book book = findBook(ISBN);

        System.out.println(user.getName() + " reserved " + book.getBookTitle());
    }

    // Search for a book by title
    @Override
    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getBookTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Helper method to find a user
    private Users findUser(String userID) throws UserNotFoundException {
        for (Users user : users) {
            if (user.getUserId().equals(userID)) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found: " + userID);
    }

    
    private Book findBook(String ISBN) throws BookNotFoundException {
        for (Book book : books) {
            if (String.valueOf(book.getIsbnNumber()).equals(ISBN)) {
                return book;
            }
        }
        throw new BookNotFoundException("Book not found: ISBN " + ISBN);
    }
}
