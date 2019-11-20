public class BeerNode {
    //instance variable
    private Beer data;
    private BeerNode rightChild;
    private BeerNode leftChild;

    public BeerNode(Beer data, BeerNode rightChild, BeerNode leftChild) {
        this.data = data;
        this.rightChild = rightChild;
        this.leftChild = leftChild;
    }

    public Beer getData() {
        return data;
    }

    public void setData(Beer data) {
        this.data = data;
    }

    public BeerNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BeerNode rightChild) {
        this.rightChild = rightChild;
    }

    public BeerNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BeerNode leftChild) {
        this.leftChild = leftChild;
    }
    public boolean isLeaf(){
        return (leftChild == null) && (rightChild == null);
    }
}