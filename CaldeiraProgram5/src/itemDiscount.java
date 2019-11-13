class ItemDiscount {
    private int discount;
    private int qualifiedQuantity;

    public ItemDiscount(int discount, int qualifiedQuantity) {
        this.discount = discount;
        this.qualifiedQuantity = qualifiedQuantity;
    }

    public double calculateDiscount(SalesItem item){
        if(item.getQuantity() >= qualifiedQuantity) {
            return item.getPrice() * (discount / 100);
        } else {
            return 0.0;
        }
    }
}