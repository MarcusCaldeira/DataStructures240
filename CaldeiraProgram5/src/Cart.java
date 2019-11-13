public class Cart {
    private SalesItem[] itemList;
    private int currentNumItems;
    public static final int BOOK = 1;
    public static final int DICTIONARY = 2;
    public static final int AUDIOCD = 3;

    public Cart(int size) {
        this.itemList = new SalesItem[size];
        this.currentNumItems = 0;
    }

    public void addItem(SalesItem addedItem){
        //If the array is full then we need to just return.
        if(currentNumItems >= itemList.length){
            return;
        }
        itemList[currentNumItems]=addedItem;
        currentNumItems++;

    }
    public double cartTotalCost() {
        double sum = 0;
        for(int i = 0; i < currentNumItems; i++)
            sum += itemList[i].itemTotalCost();
        return sum;
    }
    public SalesItem getAtIndex(Integer itemAtIndex){
        if(itemAtIndex >= 0 && itemAtIndex < currentNumItems){
            return itemList[itemAtIndex];
        }
        return null;

    }
    public int countType(int typeOfItem) {
        if(typeOfItem != BOOK && typeOfItem != DICTIONARY && typeOfItem != AUDIOCD) {
            return 0;
        }
        int count = 0;
        if(typeOfItem == BOOK) {
            for(int i = 0; i < currentNumItems; i++) {
                if(itemList[i] instanceof Book) {
                    count++;
                }
            }
        }
        if(typeOfItem == DICTIONARY) {
            for(int i = 0; i < currentNumItems; i++) {
                if(itemList[i] instanceof Dictionary) {
                    count++;
                }
            }
        }
        if(typeOfItem == 3) {
            for(int i = 0; i < currentNumItems; i++) {
                if(itemList[i] instanceof AudioCD) {
                    count++;
                }
            }
        }
        return count;
    }
    @Override
    public String toString() {
        String str = "";

        for(int i = 0; i < currentNumItems; i++) {
            str += itemList[i].toString() + "\r\n";
        }
        return str;
    }







}

