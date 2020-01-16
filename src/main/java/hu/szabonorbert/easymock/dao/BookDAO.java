package hu.szabonorbert.easymock.dao;

import hu.szabonorbert.easymock.model.Book;

public interface BookDAO {
    public void addBook(Book book);
    public void removeBook(Book book);
    public String listBooks();
    public Book removeFirst();
    public Book removeLast();
}
