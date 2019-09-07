/**
 *
 *
 * @Author Marcus Caldeira
 *
 */
public class InvoiceDriverClass {
    public static void main(String[] args) {
        Item orange = new Item("orange", 2, 1);
        System.out.println();

        Invoice one = new Invoice("Joe");
        one.addItem("Box", 23,50 );
        one.addItem("Paper", 23,50 );
        one.addItem("Cup", 23,50 );
        one.addItem("Soup", 23,50 );
        one.addItem("Tin", 23,50 );
        one.addItem("Copper", 23,50 );
        one.addItem("Iron", 23,50 );
        one.adjustPrice(0,5);
        one.adjustPrice(9,-3);
        one.applyDiscount(3, 12);

        for (int i = 0; i < 5; i++) {
            System.out.println(one.items[i]);
        }





    }

}
