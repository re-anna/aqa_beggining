package org.example.task1.Book;

public class Book implements Displayable {

    private String author;
    private String bookName;
    private int bookRelease;

    public void setAuthor(String author){
        this.author = author;
    }
    public void setBookName(String bookName){
        this.bookName = bookName;
    }
    public void setBookRelease(int bookRelease){
        this.bookRelease = bookRelease;
    }

    public String getAuthor(){
        return this.author;
    }
    public String getBookName(){
        return this.bookName;
    }
    public int getBookRelease(){
        return this.bookRelease;
    }

    @Override
    public void displayBook() {
    System.out.println("Эта книга "+ getBookName() + " была написана " + getAuthor() + " в " + getBookRelease() + " году.");
    }

}
