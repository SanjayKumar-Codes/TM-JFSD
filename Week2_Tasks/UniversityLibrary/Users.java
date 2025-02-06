package UniversityLibrary;
import java.util.*;

public class Users {
    private String name;
    private String userId;
    private List<Book> borrowedBooks; 
   
    public Users() {
        this.borrowedBooks = new ArrayList<>();
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

  
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

 
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
    

   
    @Override
    public String toString() {
        return "User: " + name + " | ID: " + userId + " | Borrowed Books: " + borrowedBooks;
    }
}
