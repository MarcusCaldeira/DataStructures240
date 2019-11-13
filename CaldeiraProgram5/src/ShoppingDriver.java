public class ShoppingDriver {
    public static void main(String[] args) {
        //Instantiate the Cart
        Cart myCart = new Cart(5);
        //Add A Book To The Cart.
        myCart.addItem(new Book(10,10.00,1,"MarkDavids",600));
        //Add A Dictionary to the Array.
        myCart.addItem(new Dictionary(17,15.00,1,"Is",1000,"English",2000));
        //Add A CD to the Array.
        myCart.addItem(new AudioCD(134,10.00,1,"RCA",17));
        //Add One of two new items.
        myCart.addItem(new Book(14,15.00,1,"MarkDavids2", 800));
        //Add Two of two new items.
        myCart.addItem(new AudioCD(135,10.00,1,"Columbia", 119));


        System.out.println(myCart.toString());




    }
}
