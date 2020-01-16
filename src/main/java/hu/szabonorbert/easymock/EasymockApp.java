package hu.szabonorbert.easymock;
import hu.szabonorbert.easymock.model.Book;
import hu.szabonorbert.easymock.service.Salesman;

public class EasymockApp {
    public static void main(String[] args) {
        Salesman mrSmith = new Salesman();
        mrSmith.getSomeBooksFromWarehouse();
        System.out.println(mrSmith.listBooks());
    }
}