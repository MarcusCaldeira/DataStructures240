/**
 *Class is used to test that the other two classes are working as expected.
 */
public class Driver {


    public static void main(String[] args) {

        BeerArrayBag bag1 = new BeerArrayBag(10);
        bag1.insert("IPA", "Surly", 5);
        bag1.insert("Budwiser Light", "Budwiser", 2);
        bag1.insert("Coors 75", "Coors", 3);
        bag1.insert("Coors Light", "Coors", 6);
        bag1.insert("Corona 45", "Corona", 7);

        bag1.size();
        System.out.println(bag1.toString());
        bag1.display("Coors");
        bag1.countOccurrences("Coors");
        Beer beer2 = new Beer();
        beer2.setName("IPA");

        System.out.println(bag1.contains(beer2));
        bag1.total();
        System.out.println(bag1.countRange(3,6));



        System.out.println(bag1.delete(beer2));
        System.out.println(bag1.delete(beer2));





//
//        Beer one = new Beer();
////        one.setName("Budwiser");
////        one.setBrand("MADEUP");
////        one.setRating(5);
////        System.out.println(one);
////        one.setName("ONe");
////        one.setBrand("TWO");
////        one.setRating(58);
////        System.out.println(one);
//        one.setName("Three");
//        one.setBrand("FOUROUROURORUROU");
//        one.setRating(812);
////        System.out.println(one);
//        Beer two = new Beer();
//        two.setName("ThrEE");
//        two.setBrand("doesnt");
//        two.setRating(812);
////        System.out.println(one);
////        System.out.println(two.equals(one));
//
//        //Creates a bag, and then assigns it a size of 5;
//        BeerArrayBag bag = new BeerArrayBag(5);
//
//        bag.insert("Beer","Two", 4);
//        bag.insert("Besaaaer","TWO", 9);
//        System.out.println(bag);
//        bag.display("Two");
//        String str1 = "Hello";
//        String str2 = "hello!";
//        System.out.print(str1);
//        //Why does this return false?
//        System.out.print(str1.equalsIgnoreCase(str2));

    }
}
