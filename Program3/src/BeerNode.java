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
    public void addBeerNodeAfter(Beer beer){
        this.link = new BeerNode(beer, this.link);
    }
    public void removeBeerNodeAfter(){
        link = link.link;
    }
    public static int listLength(BeerNode head){
        BeerNode cursor;
        int answer;


        answer = 0;
        for(cursor = head; cursor !=null; cursor=cursor.link)
            answer++;
        return answer;
    }
    public  static BeerNode listSearch(BeerNode head, Beer target){
        BeerNode cursor;
        for(cursor = head; cursor !=null; cursor = cursor.link)
            if(target == cursor.data)
                return cursor;
            return null;
    }




}
