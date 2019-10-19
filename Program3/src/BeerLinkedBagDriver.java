public class BeerLinkedBagDriver {
    public static void main(String[] args) {

        BeerLinkedBag bag1 = new BeerLinkedBag();
        BeerLinkedBag bag2 = new BeerLinkedBag();
        //assinging with no index will make it the head.
        bag2.add(new Beer(2,"Corona","Lime"));
        bag2.add(0,new Beer(1,"Budwiser","Alpha"));
        bag2.add(300,new Beer(1,"Budwiser","Beta"));
        bag2.add(1,new Beer(1,"Budwiser","Gamma1"));
        //assinging with no index will make it the head.
        bag1.add(new Beer(1,"Budwiser","Gamma2"));
        bag1.add(1,new Beer(1,"Budwiser","Gamma3"));
        bag1.add(1,new Beer(1,"Budwiser","Gamma4"));


        bag1.display();
        //Methods from BeerNode






    }
}
