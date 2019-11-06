public class Book extends SalesItem {
    protected String author;
    protected int numPages;

    public Book(int code, double price, int quantity, String author, int numPages) {
        super(code, price, quantity);
        this.author = author;
        this.numPages = numPages;
    }

    @Override
    public void monthlyPromo() {

    }
}
