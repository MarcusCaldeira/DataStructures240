public class BeerTree {
    private BeerNode root;

    public void add(Beer beer){
        if(root == null)
            root = new BeerNode(beer, null, null);
        else
            add(beer);
    }












}
