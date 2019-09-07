import javafx.scene.control.SplitMenuButton;

/**
 *
 *
 * @Author Marcus Caldeira
 *
 */
public class Invoice {
    //instance variables
    public String customersName;	// The variables take on whatever values you specify up here first.
    public Item[] items;
    public int numItems;

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
        Item newItem = new Item(name, price, weight);
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









}
