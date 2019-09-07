/**The Invoice Class contains allows you to create invoice for items and calculate costs.
 *
 * @Author Marcus Caldeira
 *August 7, 2019
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

    /**
     * Returns the total cost of an invoice object
     * @return double of the total of invoice
     */
    public double getTotal(){
        double total = 0;
        for( int i=0; i<items.length; i++){
            if(items[i] != null)
                total += items[i].getPrice();
        }
        return total ;
    }

    /**
     *Returns the total cost of invoice, after applying a discount
     * Null items are not included in this total
     * @return double total of the invoice after the discount has been applied.
     */
    public double getDiscountedTotal(){
        double totalCost = 0;
        for (int i = 0; i<items.length; i++){
            if (items[i] != null)
                totalCost += items[i].price * (100 - items[i].getCurrentDiscount()) /100;
        }
        return totalCost;
    }

    /**
     *The method returns the total weight of all the items in the array
     * @return double - the total weight of all items on the invoice.
     */
    public double getTotalWeight(){
        double totalWeight = 0;
        for(int i = 0; i<items.length; i++){
            totalWeight += items[1].getWeight();
        }
        return totalWeight;
    }

    /**
     * This method creates an object called Item, and then adds it to the array.
     * Prints an error message if the invoice is full.
     * @param name String item of invoice item.
     * @param price double price of item.
     * @param weight double weight of item.
     */
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

    /**
     *This method adjust the price of a given item number
     * @param itemNum int - index 0-4 targets the index of given number
     * @param priceAdjustment double adjust the price of a given item number.
     */
    public void adjustPrice(int itemNum, double priceAdjustment){
        if (itemNum >= 0 && itemNum < 4 && items[itemNum] != null){
            items[itemNum].adjustPrice(priceAdjustment);
        }else{
            System.out.println("The input " +itemNum + "is invalid");
        }
    }
    /**
     *Sets the current discount on of the items on the invoice.
     * @param itemNum-int the index in the array.
     * @param discount-int the discount amount youre applying.
     */
    public void applyDiscount(int itemNum, int discount){
        if(itemNum >= 0 && itemNum < 4 && items[itemNum] != null){
            items[itemNum].setCurrentDiscount(discount);
        }else{
            System.out.println("The input " +itemNum + "is invalid");
        }
    }

    /**
     *Calulcates the amount of sales tax to be paid.
     * @param cost-double the cost of the item to multiply.
     * @param taxRate-double rate at which the item is being taxed at.
     * @return returns a double that is the amount of tax to be paid.
     */
    public static double calculateTax(double cost, double taxRate){
        double tax = ((cost * taxRate) / 100);
        return tax;
    }

    /**
     *Returns a string representation of the invoice.
     * @return returns a "pretty" formatted version for you to look at.
     */
    public String toString(){
        String itemsString = "";
        for (int i =0; i < items.length; i++){
            if(items[i] != null){
                itemsString += items[i].toString()+ "\n" ;
            }
        }

        Double totalPlusTax = getDiscountedTotal() + calculateTax(getDiscountedTotal(),4.5);

        
        String str2 =("Invoice for " +customersName+ "\nItems Purchased " + numItems + "\n" +itemsString + "\n The " +
                "Total Weight For Your Order is " + getTotalWeight() + "\n" + "Total Before Discount " +getTotal() +
                "\nTotal After Discount " + getDiscountedTotal() + "\nTax Based on Discount " + calculateTax(getDiscountedTotal(),4.5)
                + "\n\nTOTAL COST: " + totalPlusTax);
        return str2;
    }
}
