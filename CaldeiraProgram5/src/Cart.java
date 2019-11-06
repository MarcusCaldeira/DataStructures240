public class Cart {
    private SalesItem[] itemList;
    private int currentNumItems;

    public Cart(int size) {
        this.itemList = new SalesItem[size];
        this.currentNumItems = 0;
    }

    public void addItem(){
        //If the array is full then we need to just return.
        if(currentNumItems >= itemList.length){
            return;
        }
    }
}
