import javafx.scene.control.skin.CellSkinBase;

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
    public boolean equals(String name, double weight){
        boolean output = false;
        if(this.name == this.name && this.weight == this.weight)
            output = true;
        else{
            output = false;
        }
        return output;
    }
    public String toString(){
        String str = "The Products name is" + name + "The Weight is" + weight + "The Price Is" +
                "The Current Discount is" + currentDiscount + ".";
        System.out.print(str);
        return str;
    }

}
