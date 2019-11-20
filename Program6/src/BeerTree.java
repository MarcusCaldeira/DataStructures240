public class BeerTree {
    private BeerNode root;

    public void add(Beer beer){
        root = add(root, beer);
    }

    private BeerNode add(BeerNode cur, Beer beer){
        if(cur == null)
            return new BeerNode(beer, null, null);
        if(beer.compareTo(cur.getData()) < 0)
            cur.setLeftChild(add(cur.getLeftChild(), beer));
        else if (beer.compareTo(cur.getData()) > 0)
            cur.setRightChild(add(cur.getRightChild(), beer));
        return cur;
    }






    public int depth(BeerNode beer){
        int leftDepth = depth(beer.getLeftChild());
        int rightDepth = depth(beer.getRightChild());
        if (root == null)
            return 0;
        else
            if(leftDepth > rightDepth)
                return leftDepth + 1;
            else return rightDepth +1;
    }




    public int count(BeerNode root){
        int numberOfNodes = 0;
        if (root == null)
            return 0;
        if(root.getLeftChild() != null && root.getRightChild() != null)
            numberOfNodes++;
        numberOfNodes += (count(root.getLeftChild())+ count(root.getRightChild()));
        return numberOfNodes;
    }















}
