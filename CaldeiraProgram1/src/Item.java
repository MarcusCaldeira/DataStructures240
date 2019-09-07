/**
 *This class represents an item being sold in a retail store.
 * @Author Marcus Caldeira
 *August 7, 2019
 */
public class Item {
    //instance variables
    String name;
    double weight;
    double price;
    int currentDiscount;

    /**
     * A constructor for the Item class.
     * @param name-The name of the item.
     * @param weight- The weight of the item.
     * @param price-The price of the item.
     */
    public Item(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.currentDiscount = 0;
    }

    /**
     * a getter for the name.
     * @return-String name.
     */
    public String getName() {
        return name;
    }

    /**
     * A getter for the weight
     * @return-Double weight.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * a getter for the price.
     * @return-double price
     */
    public double getPrice() {
        return price;
    }

    /**
     * getter for the current discount of an item.
     * @return-int the current discount of an item.
     */
    public int getCurrentDiscount() {
        return currentDiscount;
    }

    /**
     * setting the name of an item.
     * @param name the name of an item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setting the weight of an item.
     * @param weight-setting the weight of an item.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * setting the price of an item.
     * @param price setting the price of an item.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * setting the current discount
     * @param currentDiscount the current discount on an item.
     */
    public void setCurrentDiscount(int currentDiscount) {
        this.currentDiscount = currentDiscount;
    }

    /**
     * Takes an amount and and or subtracts the desired amount.
     * @param amount-returns an amount.
     */
    public void adjustPrice(double amount){
        price = price + amount;
    }

    /**
     * This method calculates and returns the discounted items price.
     * @param price the price of an item.
     * @param currentDiscount the current discount on an item.
     */
    public void priceAfterDiscount(double price, double currentDiscount){
        price = price-currentDiscount;
    }

    /**
     * tests the equality of two items.
     * @param checkEquals variable to see if items are equal.
     * @return returns true or false is an item is considered the same.
     */
    public boolean equals(Item checkEquals){
        boolean output = false;
        if(this.name == checkEquals.name && this.weight == checkEquals.weight)
            output = true;
        else{
            output = false;
        }
        return output;
    }

    /**
     * Returns a nicely formatted string description of an item.
     * @return- a string showing the item details.
     */
    public String toString(){
        String str = "The Products name is " + name + " The Weight is " + weight + " The Price Is " +
               price + " The Current Discount is " + currentDiscount + ".\n";
        return str;
    }

}
