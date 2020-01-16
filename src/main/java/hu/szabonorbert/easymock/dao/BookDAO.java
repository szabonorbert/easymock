package hu.szabonorbert.easymock.dao;

import hu.szabonorbert.easymock.model.Book;
import java.util.LinkedList;

public interface BookDAO {
    public void addBook(Book book);
    public void removeBook(Book book);
    public LinkedList<Book> listBooks();
    public Book removeFirst();
    public Book removeLast();
}
