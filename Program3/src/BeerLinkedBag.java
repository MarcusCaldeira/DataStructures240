import com.sun.source.tree.IfTree;

public class BeerLinkedBag {
    private BeerNode head;
    private int manyItems;

    public BeerLinkedBag() {
        head = null;
        manyItems = 0;
    }

    ;

    public int size() {
        return this.manyItems;
    }

    public void display() {
        BeerNode cursor;
        for (cursor = head; cursor != null; cursor = cursor.getLink()) {
            Beer display = cursor.getData();
            System.out.println(display);
        }
    }

    public void add(Beer beer) {
        head = new BeerNode(beer, head);
        manyItems++;
    }

    public void add(int index, Beer element) {
        if (index >= 0) {
            BeerNode cursor;
            int counter = 0;
            for (cursor = head; cursor != null; cursor = cursor.getLink()) {
                if (index == 0) {
                    head = new BeerNode(element, head);
                    manyItems++;
                    return;
                }
                if (counter == index - 1) {
                    cursor.addBeerNodeAfter(element);
                    manyItems++;
                    return;
                }
                if (counter >= manyItems) {
                    cursor.addBeerNodeAfter(element);
                    manyItems++;
                }
                counter++;
            }
        }
    }

    public boolean remove(Beer target) {
        BeerNode cursor;
        for (cursor = head; cursor != null; cursor = cursor.getLink()) {
            if (cursor.getLink().getData().equals(target)) {
                cursor.removeBeerNodeAfter();
                return true;
            }
        }
        return false;
    }

    public boolean remove(int index) {
        BeerNode targetNode = BeerNode.listPosition(this.head, index);
        if (targetNode == null)
            return false;
        else {
            Beer data = this.head.getData();
            targetNode.setData(data);
            manyItems--;
            this.head = this.head.getLink();
            return true;
        }
    }

    public int countRage(Beer start) {
        int count = 0;
        BeerNode cursor = head;
        while (cursor != null) {
            if (cursor.getData() == start)
                count++;
            cursor = cursor.getLink();
        }
        return count;
    }

    public Beer grab(int index) {
        BeerNode cursor = head;
        int target = 1;
        while (cursor != null) {
            if (target == index) {
                return cursor.getData();
            }
            target++;
            cursor = cursor.getLink();
        }
        return null;
    }

    public int indexOf(Beer target) {
        BeerNode cursor = head;
        int index = 1;
        while (cursor != null) {
            if (cursor.getData().compareTo(target) == 0) {
                return index;
            }
            index++;
            cursor = cursor.getLink();
        }
        return -1;
    }
    public void set(int index, Beer element) {
        BeerNode cursor = head;
        if (manyItems > index && index < 0) {
            //while (index != null){
            for (int i = 0; i < index; i++) { // Gives us a nice counter and makes sure we don't run past our index.
                if (i == (index - 1)) {
                    //if(cursor.getData() == index){
                    //index++;
                    cursor.addBeerNodeAfter(element);

                    //}
                } else {
                    cursor = cursor.getLink();
                }
            }
        }
    }
    public boolean replace(Beer oldBeer, Beer newBeer){
        BeerNode cursor = head;
        //BeerNode previous = null;
        for (int i = 0; i < manyItems; i++){
            if(cursor.getData().equals(oldBeer)){
                cursor.setData(newBeer);
                return true;
            }
            //previous = cursor;
            cursor = cursor.getLink();
        }

        return false;
    }
    public int totalValue(){
        BeerNode cursor = head;
        int sum = 0;
        while (cursor!= null) {
            sum = sum + cursor.getData().getRating();
            cursor = cursor.getLink();
        }
        return sum;
    }
    public BeerNode lessThan(Beer element){
        BeerLinkedBag list = new BeerLinkedBag;
        BeerNode cursor = head;
        while (cursor!= null){
            if(cursor.getData().compareTo(element) <= 0){
                list.add(cursor.getData());
            }
            cursor = cursor.getLink();
        }
        return list.head;
    }
    public BeerNode greaterThan(Beer element){
        BeerLinkedBag list2 = new BeerLinkedBag;
        BeerNode cursor = head;
        while (cursor!= null){
            if(cursor.getData().compareTo(element) < 0){
                list2.add(cursor.getData());
            }
            cursor = cursor.getLink();
        }
        return list2.head;
    }








    //getMax
    //getMin












}
