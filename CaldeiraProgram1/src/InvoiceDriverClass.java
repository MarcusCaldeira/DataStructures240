/**
 *
 *
 * @Author Marcus Caldeira
 *
 */
public class InvoiceDriverClass {
    public static void main(String[] args) {
        //Creating The First Two Invoices.
        Invoice one = new Invoice("BOB");
        Invoice two = new Invoice("Marcus");
        //Adding Three items to the first invoice.
        one.addItem("Paper",10,2);
        one.addItem("Rock",20,50);
        one.addItem("Scissors",4,1);
        //Two Items to the second invoice
        two.addItem("Water",5,1);
        two.addItem("Wine",20,2);
        //Applying a 10% discount to item 1 in both invoices
        one.applyDiscount(0, 10);
        two.applyDiscount(0, 10);
        //Apple a 20% discount to item two;
        one.applyDiscount(1,20);
        two.applyDiscount(1, 20 );
        //Adjust the price of item 3 in the first invoice
        one.adjustPrice(2,2);
        //Print Both The Invoices Out.
        System.out.println(one.toString());
        System.out.println(two.toString());









        /**
         *
         * @Params The Test Code I Used Along the way...
         *
         *
         *
         */
//        Item orange = new Item("orange", 2, 1);
//        System.out.println();
//
//        Invoice one = new Invoice("Joe");
//        one.addItem("Box", 23,50 );
//        one.addItem("Paper", 23,50 );
//        one.addItem("Cup", 23,50 );
//        one.addItem("Soup", 23,50 );
//        one.addItem("Tin", 23,50 );
//        one.addItem("Copper", 23,50 );
//        one.addItem("Iron", 23,50 );
//        one.adjustPrice(0,5);
//        one.adjustPrice(9,-3);
//        one.applyDiscount(3, 12);
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println(one.items[i]);
//        }
//        System.out.println("static method test: "+ Invoice.calculateTax(one.getDiscountedTotal(),10));
//        System.out.println("\n\n");
//
//        System.out.println(one.toString());
    }

}
