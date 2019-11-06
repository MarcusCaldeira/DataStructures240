public class Cart {
    private SalesItem[] itemList;
    private int currentNumItems;

    public Cart(int size) {
        this.itemList = new SalesItem[size];
        this.currentNumItems = 0;
    }
}
