public class BeerLinkedBagDriver {
    public static void main(String[] args) {



        BeerLinkedBag bag1 = new BeerLinkedBag();
        BeerLinkedBag bag2 = new BeerLinkedBag();
        bag2.add(new Beer(2,"Corona","Lime"));
        bag2.add(0,new Beer(1,"Budwiser","Light"));
        bag2.add(300,new Beer(1,"Budwiser","Light"));
        bag2.add(1,new Beer(1,"Budwiser","Light"));
        bag1.display();
        System.out.println(bag1.size());
        System.out.println(bag2.size());





        System.out.print("HI Im running");
    }
}
