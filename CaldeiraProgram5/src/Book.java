public class Book extends SalesItem {
    protected String author;
    protected int numPages;

    public Book(int code, double price, int quantity, String author, int numPages) {
        super(code, price, quantity);
        this.author = author;
        this.numPages = numPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    @Override
    public void monthlyPromo() {
        double currentPrice = this.getPrice() - (this.getPrice() * 0.03);
        this.setPrice(currentPrice);
    }
    @Override
    public String toString(){
        String str = String.format("%s	%s	%d	",super.toString(),author,numPages);
        return str;
    }



}
