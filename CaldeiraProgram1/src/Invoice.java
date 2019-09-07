import javafx.scene.control.SplitMenuButton;

/**
 *
 *
 * @Author Marcus Caldeira
 *
 */
public class Invoice {
    //instance variables
    public String customersName;// The variables take on whatever values you specify up here first.
    public Item[] items;
    public int numItems;

    /**
     * Constructor for the Invoice class
     * @param customersName Name of customer
     */
    public Invoice(String customersName) {

        // and then their values get changed to these.
        this.customersName = customersName;
        this.items = new Item[5];
        numItems = 0;
    }
    public double getTotal(){
        double total = 0;
        for( int i=0; i<items.length; i++){
            if(items[i] != null)
                total += items[i].getPrice();
        }
        return total ;
    }
    public double getDiscountedTotal(){
        double totalCost = 0;
        for (int i = 0; i<items.length; i++){
            if (items[1] != null)
                totalCost -= items[i].getCurrentDiscount();
        }
        return totalCost;
    }
    public double getTotalWeight(){
        double totalWeight = 0;
        for(int i = 0; i<items.length; i++){
            totalWeight += items[1].getWeight();
        }
        return totalWeight;
    }
    public void addItem(String name, double price, double weight) {
        Item newItem = new Item(name,weight,price);
        boolean isAdded = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null){ // check if the current item in items is set to null
                items[i] = newItem;
                isAdded = true;
                break; // exit loop
            }
        }
        if(!isAdded){
            System.out.println("Invoice already has five items");
        }
    }
    public void adjustPrice(int itemNum, double priceAdjustment){
        if (itemNum >= 0 && itemNum < 4 && items[itemNum] != null){
            items[itemNum].adjustPrice(priceAdjustment);
        }else{
            System.out.println("The input " +itemNum + "is invalid");
        }
    }
    public void applyDiscount(int itemNum, int discount){
        if(itemNum >= 0 && itemNum < 4 && items[itemNum] != null){
            items[itemNum].setCurrentDiscount(discount);
        }else{
            System.out.println("The input " +itemNum + "is invalid");
        }
    }
    public static void calculateTax(double cost, double taxRate){
        double tax = ((cost * taxRate) / 100);
    }
    public String toString(){
        String itemsString = "";
        for (int i =0; i < items.length; i++){
            if(items[i] != null){
                itemsString += items[i].toString()+ "\n" ;
            }
        }

        
        String str2 =("Invoice for " +customersName+ "\nItems Purchased " + numItems + "\n" +itemsString + "\n The " +
                "Total Weight For Your Order is " + getTotalWeight()) + "\n" + "Total Before Discount " +getTotal() +
                "\nTotal After Discount" + getDiscountedTotal();
        return str2;
    }









}
