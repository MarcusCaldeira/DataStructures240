/**
 *Class is used to test that the other two classes are working as expected.
 */
public class Driver {


    public static void main(String[] args) {




        Beer one = new Beer();
//        one.setName("Budwiser");
//        one.setBrand("MADEUP");
//        one.setRating(5);
//        System.out.println(one);
//        one.setName("ONe");
//        one.setBrand("TWO");
//        one.setRating(58);
//        System.out.println(one);
        one.setName("Three");
        one.setBrand("FOUROUROURORUROU");
        one.setRating(812);
//        System.out.println(one);
        Beer two = new Beer();
        two.setName("ThrEE");
        two.setBrand("doesnt");
        two.setRating(812);
//        System.out.println(one);
//        System.out.println(two.equals(one));

        //Creates a bag, and then assigns it a size of 5;
        BeerArrayBag bag = new BeerArrayBag(5);

        bag.insert("Beer","Two", 4);
        bag.insert("Besaaaer","Three", 9);
        System.out.println(bag);


//        String str1 = "Hello";
//        String str2 = "hello!";
//        System.out.print(str1);
//        //Why does this return false?
//        System.out.print(str1.equalsIgnoreCase(str2));

    }
}
