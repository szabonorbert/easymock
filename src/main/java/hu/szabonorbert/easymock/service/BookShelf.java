package hu.szabonorbert.easymock.service;
import hu.szabonorbert.easymock.model.Book;
import hu.szabonorbert.easymock.dao.BookDao;
import java.util.LinkedList;

public class BookDaoImpl implements BookDao {

    LinkedList<Book> books;
    public BookDaoImpl(){
        books = new LinkedList<Book>();
    }

    public void addBook(Book b){
        books.add(b);
    }

    public void removeBook(Book book){
        int id = -1;
        for (int i = 0; i<books.size(); i++){
            if (books.get(i).equals(book)) id = i;
        }
        if (id != -1) books.remove(id);
    }

    public String listBooks(){
        String ret = new String();
        for(Book b:books){
            ret += b.toString() + "\n";
        }
        return ret;
    }

    public Book removeFirst(){
        return books.removeFirst();
    }

    public Book removeLast(){
        return books.removeLast();
    }

    public void magicRejtoJenoing(){
        books.clear();
        addBook(new Book("Rejtő Jenő", "Az elveszett cirkáló", 1938));
        addBook(new Book("Rejtő Jenő", "A szőke ciklon", 1939));
        addBook(new Book("Rejtő Jenő", "Az előretolt helyőrség", 1939));
        addBook(new Book("Rejtő Jenő", "Vesztegzár a Grand Hotelben", 1940));
        addBook(new Book("Rejtő Jenő", "Az elátkozott part", 1940));
        addBook(new Book("Rejtő Jenő", "A három testőr Afrikában", 1940));
    }
}
