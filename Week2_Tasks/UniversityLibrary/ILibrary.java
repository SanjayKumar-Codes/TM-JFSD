package UniversityLibrary;


public interface ILibrary {
    void borrowBook(String isbn, String userId) throws BookNotFoundException, UserNotFoundException, MaxBooksAllowedException;
    void returnBook(String isbn, String userId) throws BookNotFoundException, UserNotFoundException;
    void reserveBook(String isbn, String userId) throws BookNotFoundException, UserNotFoundException;
    Book searchBook(String title);
}

