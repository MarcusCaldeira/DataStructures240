public abstract class SalesItem {
    private int code;
    private double price;
    private int quantity;

    public SalesItem(int code, double price, int quantity) {
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double itemTotalCost(){
        return price*quantity;
    }
    public abstract void monthlyPromo();
    @Override
    public String toString(){
        String str = String.format("%d\t%d\t%d\t",code,price,quantity);
        return str;
    }




}