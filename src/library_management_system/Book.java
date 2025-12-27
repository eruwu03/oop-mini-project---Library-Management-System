package library_management_system;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private String publish;
    private String category;
    
    
   public Book(String bookId, String title, String author, String publish, String category){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publish = publish;
       this.category = category;
    }
    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public void display() {
        System.out.println("Book ID: " + bookId + ", Book Title: " + title + 
                          ", Book Author: " + author + ",Book Publish: " + publish +" Category: " + category);
    }
    
}



   
