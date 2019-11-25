public class BeerTree {
    private BeerNode root;

    public void add(Beer beer) {
        if (root == null) {
            //Start of new Tree
            root = new BeerNode(beer, null, null);
        } else {
            add(root, beer);
        }
    }

    private void add(BeerNode cur, Beer beer) {
        if (beer.compareTo(cur.getData()) < 0) {
            if (cur.getLeftChild() != null)
                add(cur.getLeftChild(), beer);
            else {
                cur.setLeftChild(new BeerNode(beer, null, null));
            }
        } else {
            if (cur.getRightChild() != null)
                add(cur.getRightChild(), beer);
            else cur.setRightChild(new BeerNode(beer, null, null));
        }
    }
    private void preOrder(BeerNode cur){
        System.out.println(cur.getData() + "\t");
        if(cur != null)
            preOrder(cur.getLeftChild());
        if(root.getRightChild() != null)
            preOrder(cur.getRightChild());
    }
    public void preOrder(){
        preOrder(root);
    }

    private void postOrder(BeerNode cur){
        if(cur.getLeftChild() != null)
            postOrder(cur.getLeftChild());
        if(cur.getRightChild() != null)
            postOrder(cur.getRightChild());
        System.out.println(cur.getData() + "\t");
    }
    public  void postOrder(){
        preOrder(root);
    }
    private void inOrder(BeerNode cur){
        if(cur != null)
            inOrder(cur.getLeftChild());
        System.out.println(cur.getData() + "\t");
        inOrder(cur.getRightChild());
    }
    public void inOrder(){
        inOrder(root);
    }




    /**
     * This method calculates the depth of the tree
     *
     * @param root the starting node of three, that acts as the base to count of off.
     * @return will return the the depth of the tree, despite which side is larger.
     */
    public int depth(BeerNode root) {
        int leftDepth = depth(root.getLeftChild());
        int rightDepth = depth(root.getRightChild());
        if (this.root == null)
            return 0;
        else if (leftDepth > rightDepth)
            return leftDepth + 1;
        else return rightDepth + 1;
    }


}
