package hu.szabonorbert.easymock.service;

import hu.szabonorbert.easymock.model.Book;

import java.util.LinkedList;

public class Salesman {

    private BookShelf bookShelf;

    public Salesman(BookShelf bs){
        this.bookShelf = bs;
    }

    public Salesman(){
        bookShelf = new BookShelf();
    }

    public BookShelf getBookShelf() {
        return bookShelf;
    }

    public void setBookShelf(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    public String listBooks(){
        String ret = new String();
        LinkedList<Book> books = bookShelf.listBooks();
        for(Book b:books){
            ret += b.toString() + "\n";
        }
        return ret;
    }

    public String listBooksByAuthor(String author){
        String ret = new String();
        LinkedList<Book> books = bookShelf.listBooks();
        for(Book b:books){
            if (b.getAuthor().equals(author)) ret += b.toString() + "\n";
        }
        return ret;
    }

    public String listBooksByDate(int date){
        String ret = new String();
        LinkedList<Book> books = bookShelf.listBooks();
        for(Book b:books){
            if (b.getPublishDate() == date) ret += b.toString() + "\n";
        }
        return ret;
    }

    public boolean hasBookByAuthor(String author){
        LinkedList<Book> books = bookShelf.listBooks();
        for(Book b:books){
            if (b.getAuthor().equals(author)) return true;
        }
        return false;
    }

    public boolean hasBookByDate(int date){
        LinkedList<Book> books = bookShelf.listBooks();
        for(Book b:books){
            if (b.getPublishDate() == date) return true;
        }
        return false;
    }

    public boolean hasBook(Book book){
        LinkedList<Book> books = bookShelf.listBooks();
        for(Book b:books){
            if (b.equals(book)) return true;
        }
        return false;
    }

    public Book getBook(Book b) {
        if (hasBook(b)){
            bookShelf.removeBook(b);
            return b;
        }
        return null;
    }

    public void getSomeBooksFromWarehouse(){
        bookShelf.magicRejtoJenoing();
    }
}
