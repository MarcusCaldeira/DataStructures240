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
    public void addItem(String name, double price, double weight){
        Item newItem = new Item(name, price, weight);
        for(int i =0;i<items.length; i++){
            if (items[1] == null){
                items[1] = newItem;
            }
            else {
                items[5] != null
            }

        }
    }




    }








}
