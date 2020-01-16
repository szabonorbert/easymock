package hu.szabonorbert.easymock;
import hu.szabonorbert.easymock.model.Book;
import hu.szabonorbert.easymock.service.BookShelf;

public class EasymockApp {
    public static void main(String[] args) {
        BookShelf bookshelf = new BookShelf();
        bookshelf.magicRejtoJenoing();
        String list = bookshelf.listBooks();
        System.out.println(list);
    }
}