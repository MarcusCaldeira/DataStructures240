public class BeerTree {
    private BeerNode root;
    public static boolean flag = false;

    public void add(Beer beer) {
        if (root == null) {
            //Start of new Tree
            root = new BeerNode(beer, null, null);
        } else {
            add(root, beer);
        }
    }

    private void add(BeerNode cur, Beer beer) {
        // if the beer added comes before  or is the same as the current beer in the alphabet it is added to the left
        if (cur.getData().compareTo(beer) >= 0) {
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

//        switch (beer.compareTo())
    }

    private void preOrder(BeerNode cur) {
        if (cur == null)
            return;
        System.out.println(cur.getData() + "	");
        if (cur != null)
            preOrder(cur.getLeftChild());
        if (root.getRightChild() != null)
            preOrder(cur.getRightChild());
    }

    public void preOrder() {
        preOrder(root);
    }

    private void postOrder(BeerNode cur) {
        if (cur == null) {
            return;
        }
        if (cur.getLeftChild() != null)
            postOrder(cur.getLeftChild());
        if (cur.getRightChild() != null)
            postOrder(cur.getRightChild());
        System.out.println(cur.getData() + "	");
    }

    public void postOrder() {
        postOrder(root);
    }

    private void inOrder(BeerNode cur) {
        if (cur != null) {
            inOrder(cur.getLeftChild());
            System.out.println(cur.getData());
            inOrder(cur.getRightChild());
        }

    }

    public void inOrder() {
        inOrder(root);
    }

    /**
     * This method calculates the depth of the tree
     *
     * @param node the starting node of three, that acts as the base to count of off.
     * @return will return the the depth of the tree, despite which side is larger.
     */
    private int depth(BeerNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftDepth = depth(node.getLeftChild());
            int rightDepth = depth(node.getRightChild());
            if (leftDepth > rightDepth) {
                return leftDepth + 1;
            } else {
                return rightDepth + 1;
            }
        }
    }

    public int depth() {
        return depth(root);
    }

    private int count(BeerNode node) {
        if (node == null) {
            return 0;
        } else {
            int count = 1;
            count += count(node.getLeftChild());
            count += count(node.getRightChild());
            return count;
        }
    }

    public int count() {
        return count(root);
    }

    /**
     * Recursively search the Bear node with a Beer with the provided name
     *
     * @param root current root of the the tree
     * @param item the Beer with the name to search on
     * @return The data for the target Beer
     */
    private Beer search(BeerNode root, Beer item) {
        if (root == null || root.getData().equals(item))
            return root == null ? null : root.getData();

        if (root.getData().getRating() > item.getRating())
            return search(root.getLeftChild(), item);

        return search(root.getRightChild(), item);

    }

    public Beer search(Beer item) {
        // and then pass in the item
        return search(root, item);
    }


}
