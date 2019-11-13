public class ShoppingDriver {
    public static void main(String[] args) {
        Cart myCart = new Cart(5);
        Book myBook = (new Book(10,10.00,1,"MarkDavids",600));
        myCart.addItem(myBook);
        Dictionary myDictionary = new Dictionary(17,15.00,1,"Is",1000,"English",2000);
        myCart.addItem(new AudioCD(134,10.00,1,"RCA",17));


        System.out.println(myCart.toString());




    }
}
