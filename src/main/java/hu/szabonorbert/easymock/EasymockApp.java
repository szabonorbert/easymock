package hu.szabonorbert.easymock;
import hu.szabonorbert.easymock.model.Book;
import hu.szabonorbert.easymock.service.BookDao;

public class EasymockApp {
    public static void main(String[] args) {
        BookDao bookshelf = new BookDao();
        bookshelf.magicRejtoJenoing();
        String list = bookshelf.listBooks();
        System.out.println(list);
    }
}