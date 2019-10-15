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
        BeerNode cursor;
        if (index > manyItems) {
            return null;
        }
        cursor = BeerNode.listPosition(head, index);
        return cursor.getData();
    }
    public int indexOf(Beer target){
        BeerNode cursor = head;
        int index = 1;
        while (cursor != null){
            if (cursor.getData().compareTo(target) == 0){
                return index;
            }
            index++;
            cursor = cursor.getLink();
        }
        return -1;
    }


}
