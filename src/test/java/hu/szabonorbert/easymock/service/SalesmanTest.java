package hu.szabonorbert.easymock.service;

import hu.szabonorbert.easymock.model.Book;
import org.easymock.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;


@RunWith(JUnit4.class)
public class SalesmanTest {

    @Mock
    public BookShelf bookshelf;

    @TestSubject
    private Salesman salesman;

    @Before
    public void setUp(){
        bookshelf = EasyMock.niceMock(BookShelf.class);
        salesman = new Salesman(bookshelf);
    }

    @Test
    public void testListBooks() {
        LinkedList<Book> dummyDB = new LinkedList();
        dummyDB.add(new Book("Rejtő Jenő", "Az elveszett cirkáló", 1938));
        EasyMock.expect(bookshelf.listBooks()).andReturn(dummyDB);
        EasyMock.replay(bookshelf);
        Assert.assertEquals("Book{author='Rejtő Jenő', title='Az elveszett cirkáló', publishDate=1938}\n", salesman.listBooks());
    }

    @Test
    public void testListBooksByAuthor(){
        LinkedList<Book> dummyDB = new LinkedList();
        dummyDB.add(new Book("Rejtő Jenő", "Az elveszett cirkáló", 1938));
        dummyDB.add(new Book("Rejtő Jenő", "Vesztegzár a Grand Hotelben", 1940));
        dummyDB.add(new Book("Mihail Csehov", "A színészhez", 1997));
        EasyMock.expect(bookshelf.listBooks()).andReturn(dummyDB);
        EasyMock.replay(bookshelf);

        Assert.assertEquals("Book{author='Rejtő Jenő', title='Az elveszett cirkáló', publishDate=1938}\nBook{author='Rejtő Jenő', title='Vesztegzár a Grand Hotelben', publishDate=1940}\n", salesman.listBooksByAuthor("Rejtő Jenő"));
    }

    @Test
    public void testListBooksByAuthor2(){
        LinkedList<Book> dummyDB = new LinkedList();
        dummyDB.add(new Book("Rejtő Jenő", "Az elveszett cirkáló", 1938));
        dummyDB.add(new Book("Rejtő Jenő", "Vesztegzár a Grand Hotelben", 1940));
        dummyDB.add(new Book("Mihail Csehov", "A színészhez", 1997));
        EasyMock.expect(bookshelf.listBooks()).andReturn(dummyDB);
        EasyMock.replay(bookshelf);

        Assert.assertEquals("Book{author='Mihail Csehov', title='A színészhez', publishDate=1997}\n", salesman.listBooksByAuthor("Mihail Csehov"));
    }

    @Test
    public void testListBooksByAuthor3(){
        LinkedList<Book> dummyDB = new LinkedList();
        dummyDB.add(new Book("Rejtő Jenő", "Az elveszett cirkáló", 1938));
        dummyDB.add(new Book("Rejtő Jenő", "Vesztegzár a Grand Hotelben", 1940));
        dummyDB.add(new Book("Mihail Csehov", "A színészhez", 1997));
        EasyMock.expect(bookshelf.listBooks()).andReturn(dummyDB);
        EasyMock.replay(bookshelf);

        Assert.assertEquals("", salesman.listBooksByAuthor("J.K. Rowling"));
    }
}