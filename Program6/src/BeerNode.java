public class BeerNode {
    //instance variable
    private Beer data;
    private BeerNode link;

    //two-arg constructor
    public BeerNode(Beer data, BeerNode link) {
        this.data = data;
        this.link = link;
    }
    //getters and setters
    public Beer getData() {
        return data;
    }

    public void setData(Beer data) {
        this.data = data;
    }

    public BeerNode getLink() {
        return link;
    }

    public void setLink(BeerNode link) {
        this.link = link;
    }


}