/**
 *
 *
 * @Author Marcus Caldeira
 *August 7, 2019
 */
public class Item {
    //instance variables
    String name;
    double weight;
    double price;
    int currentDiscount;

    public Item(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.currentDiscount = 0;
    }
    //getters
    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public int getCurrentDiscount() {
        return currentDiscount;
    }
    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCurrentDiscount(int currentDiscount) {
        this.currentDiscount = currentDiscount;
    }
    //methods
    public void adjustPrice(double amount){
        price = price + amount;
    }
    public void priceAfterDiscount(double price, double currentDiscount){
        price = price-currentDiscount;
    }
    public boolean equals(Item checkEquals){
        boolean output = false;
        if(this.name == checkEquals.name && this.weight == checkEquals.weight)
            output = true;
        else{
            output = false;
        }
        return output;
    }
    public String toString(){
        String str = "The Products name is " + name + " The Weight is " + weight + " The Price Is " +
               price + " The Current Discount is " + currentDiscount + ".\n";
        return str;
    }

}
