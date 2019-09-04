* @Author Marcus Caldeira
        *
        */
public class Invoice {
    //instance variables
    public String customersName;	// The variables take on whatever values you specify up here first.
    public Item[] items = null;
    public int numItems;

    public Invoice(String customersName) {

        // and then their values get changed to these.
        this.customersName = customersName;
        this.items = new Item[5];
    }

    public static void main(String[] args)
    {
        // Every instance of Invoice has totally separate customerName, items, and numItems variables.
        Invoice myTestInvoice = new Invoice("John Smith");

        Invoice anotherInvoice = new Invoice("Jane Doe");

        // Will print John Smith.
        System.out.println(myTestInvoice.customerName);

        // Will print Jane Doe. They're two totally different customer names.
        System.out.println(anotherInvoice.customerName);
    }




}
