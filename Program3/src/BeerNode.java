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
    public static void display(BeerNode list){
        BeerNode cursor = list;

        while(cursor != null){
            System.out.println(cursor.data);
            cursor = cursor.getLink();
        }
    }
    public static BeerNode listPosition(BeerNode head, int position){
        BeerNode cursor;
        int i;
        if(position <= 0)
            throw new IllegalArgumentException("position is not positive.");
            cursor = head;
            for (i = 1; (i < position) && (cursor != null); i++)
                cursor = cursor.link;
            return cursor;
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
