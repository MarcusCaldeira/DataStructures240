public class BeerTree {
    private BeerNode root;

    //    public void add(Beer beer){
//        root = add(root, beer);
//    }
//    private BeerNode add(BeerNode cur, Beer beer){
//        if(cur == null)
//            return new BeerNode(beer, null, null);
//        if(beer.compareTo(cur.getData()) < 0)
//            cur.setLeftChild(add(cur.getLeftChild(), beer));
//        else if (beer.compareTo(cur.getData()) > 0)
//            cur.setRightChild(add(cur.getRightChild(), beer));
//        return cur;
//    }
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

    /**
     * This method prints the list in PreOrder.
     *
     * @param node it takes in one node.
     */
    public void preorder(BeerNode node) {
        System.out.println(node.getData() + "\t");
        if (node.getLeftChild() != null)
            preorder(node.getLeftChild());
        if (node.getRightChild() != null)
            preorder(node.getRightChild());
    }

    /**
     * This method prints in the list in Postorder
     *
     * @param node it takes in a node.
     */
    public void postorder(BeerNode node) {
        if (node.getLeftChild() != null)
            postorder(node.getLeftChild());
        if (node.getRightChild() != null)
            preorder(node.getLeftChild());
        System.out.println(node.getData() + "\t");
    }

    /**
     * This method prints the list Inorder
     *
     * @param node
     */
    public void inorder(BeerNode node) {
        if (node.getLeftChild() != null)
            inorder(node.getLeftChild());
        System.out.println(node.getData() + "\t");
        if (node.getRightChild() != null)
            inorder(node.getRightChild());
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
