import com.sun.source.tree.IfTree;

public class BeerLinkedBag {
    private BeerNode head;
    private  int manyItems;

    public BeerLinkedBag(){
        head = null;
        manyItems = 0;
    };
    public int size(){
        return this.manyItems;
    }
    public void display(){
        BeerNode cursor;
        for(cursor = head;  cursor!=null; cursor = cursor.getLink()){
            Beer display = cursor.getData();
            System.out.println(display);
        }
    }
    public void add(Beer beer){
        head = new BeerNode(beer, head);
        manyItems++;
    }
    public void add(int index, Beer element){
        if(index >= 0){
            BeerNode cursor;
            int counter = 0;
            for(cursor = head; cursor!=null; cursor = cursor.getLink()){
                 counter++;
                 if(counter == index-1 ){
                     cursor.addBeerNodeAfter(element);
                     return;
                 }
            }
            cursor.addBeerNodeAfter(element);
        }
    }
    public boolean remove(Beer target){
        BeerNode cursor;
        for(cursor = head; cursor!=null; cursor = cursor.getLink()){
            if(cursor.getLink().getData().equals(target)){
                cursor.removeBeerNodeAfter();
                return true;
            }
        }
        return false;
    }
    public boolean remove(Beer index){
        BeerNode targetNode = BeerNode.listSearch(this.head,index);
        if(targetNode== null)
            return false;
        else {
            Beer data = this.head.getData();
            targetNode.setData(data);
            manyItems--;
            this.head = this.head.getLink();
            return true;
        }
    }
    public int countRage(Beer start, Beer end){

    }




}
