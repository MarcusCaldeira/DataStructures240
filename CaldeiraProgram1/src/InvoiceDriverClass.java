/**
 *
 *
 * @Author Marcus Caldeira
 *
 */
public class InvoiceDriverClass {
    public static void main(String[] args) {
        Item orange = new Item("orange", 2, 1);
        System.out.println(orange);

        Invoice one = new Invoice("Joe");
        one.addItem("Box", 23,50 );
        one.addItem("Box", 23,50 );
        one.addItem("Box", 23,50 );
        one.addItem("Box", 23,50 );
        one.addItem("Box", 23,50 );


    }

}
