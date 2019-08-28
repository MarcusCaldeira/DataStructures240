/**
 *
 *
 * @Author Marcus Caldeira
 *
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
    public double adjustPrice(double amount){
        if (amount>=0){
            price++;
            return amount;
        }else{
            price--;
            return amount;
        }
    }
    public double priceAfterDiscount(double price, double currentDiscount){
        return price-currentDiscount;
    }
    public




}
