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
            if(items[i] = !null)
                total += items[i].getPrice();
        }
        
        return total ;
    }








}
