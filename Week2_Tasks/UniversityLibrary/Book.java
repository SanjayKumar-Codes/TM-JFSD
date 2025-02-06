package UniversityLibrary;

public class Book {
    private String bookTitle;
    private String author;
    private String isbnNumber; 

    // Getters and Setters
    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getIsbnNumber() { 
        return isbnNumber;
    }
    public void setIsbnNumber(String isbnNumber) { 
        this.isbnNumber = isbnNumber;
    }  

    @Override
    public String toString() {
        return "Book Title: " + bookTitle + " | Author: " + author + " | ISBN: " + isbnNumber;
    }
}
