public class BeerNode {
    /**
     * Instance Variables of the BeerNode Class
     */
    private Beer data;
    private BeerNode rightChild;
    private BeerNode leftChild;

    /**
     * constructor for the BeerNode
     * @param data
     * @param rightChild
     * @param leftChild
     */
    public BeerNode(Beer data, BeerNode rightChild, BeerNode leftChild) {
        this.data = data;
        this.rightChild = rightChild;
        this.leftChild = leftChild;
    }

    /**
     * Getter method for data inside of beer
     * @return
     */
    public Beer getData() {
        return data;
    }
    /**
     * setter for the data inside of the beer node.
     * @param data
     */
    public void setData(Beer data) {
        this.data = data;
    }

    /**
     * gets the right child of the parent node=.
     * @return returns a beer node on the right.
     */
    public BeerNode getRightChild() {
        return rightChild;
    }

    /**
     * Sets the right child inside the BeerNode
     * @param rightChild
     */
    public void setRightChild(BeerNode rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * Gets the beer node to the left of the parent.
     * @return will return the left child.
     */
    public BeerNode getLeftChild() {
        return leftChild;
    }

    /**
     * This will set the left child of the node
     * @param leftChild
     */
    public void setLeftChild(BeerNode leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * This method is used to check if the lead is actually a leaf.
     * @return will return if a child is null or isnt null.
     */
    public boolean isLeaf(){
        return (leftChild == null) && (rightChild == null);
    }
}