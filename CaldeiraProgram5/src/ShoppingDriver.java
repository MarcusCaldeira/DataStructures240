public class ShoppingDriver {
    public static void main(String[] args) {
        //Instantiate the Cart
        Cart myCart = new Cart(5);
        //Add A Book To The Cart.
        myCart.addItem(new Book(10,10.00,11,"MarkDavids",600));
        //Add A Dictionary to the Array.
        myCart.addItem(new Dictionary(17,15.00,12,"Is",1000,"English",2000));
        //Add A CD to the Array.
        myCart.addItem(new AudioCD(134,10.00,1,"RCA",17));
        //Add One of two new items.
        myCart.addItem(new Book(14,15.00,1,"MarkDavids2", 800));
        //Add Two of two new items.
        myCart.addItem(new AudioCD(135,10.00,1,"Columbia", 119));
        //Display the cart
        System.out.println("\nItems in the cart \n" + myCart.toString());
        //An Item Discount Class that applies a 15% discount if 10 or more are bought together.
        ItemDiscount d = new ItemDiscount(15,10);
        double totalQuantityDiscount = 0.00;
        //Gives us the discount of all items
        for (int i = 0; i < 5; i++) {
            SalesItem si = myCart.getAtIndex(i);
            myCart.getAtIndex(i).monthlyPromo();
            totalQuantityDiscount += d.calculateDiscount(si);
            System.out.printf("\nTotal Discount Per Item: $%.2f",d.calculateDiscount(si));
        }
        //Display the total discount to be applied to the cart.
        System.out.printf("\nTotal Discount: $%.2f",+totalQuantityDiscount);

        //Diplay the total cart cost before the discount.
        System.out.printf("\nTotal Cost Before Discount: $%.2f", myCart.cartTotalCost());
        //Display the total cart cost after the discount.
        System.out.printf("\nTotal Cost After Discount: $%.2f", (myCart.cartTotalCost()- totalQuantityDiscount));

    }
}
