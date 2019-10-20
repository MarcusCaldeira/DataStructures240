/**
 *This class is the linked bag list list for the beer nodes class.
 * The invariance for this class are stored in a variable called data,
 * The number of items are stored in a variable called many items.
 */
public class BeerLinkedBag {
    private BeerNode head;
    private int manyItems;

    /**
     * A constructor to create an empty array list.
     */
    public BeerLinkedBag() {
        head = null;
        manyItems = 0;
    }

    /**
     * Method to return the number of nodes in the list.
     * @return and integer that is the size of nodes in the list.
     */
    public int size() {
        return this.manyItems;
    }
    /**
     * Method to display the contents of the collection.
     */
    public void display() {
        BeerNode cursor;
        for (cursor = head; cursor != null; cursor = cursor.getLink()) {
            Beer display = cursor.getData();
            System.out.println(display);
        }
    }
    /**
     * Method to add a beer at the head(with no index)
     * @param beer takes A beer as the head of the list.
     */
    public void add(Beer beer) {
        head = new BeerNode(beer, head);
        manyItems++;
    }
    /**
     * Method to add a node, after the head has been created.
     * @param index requires an index for it to be placed.
     * @param element requires the actual beer youre placing into the list.
     */
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
    /**
     * removes a beer at a specific target.
     * @param target takes in the beer you are trying to remove.
     * @return a boolean value if it removed the beer.
     */
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
    /**
     * Method to move a node at a specific index.
     * @param index takes in the index of a node.
     * @return will return a true if it has removed the node and a false if it hasnt.
     */
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
    /**
     * will count the range between brands alphabetically by strings total value.
     * @param start the start of string
     * @param end the end of the range of the strings.
     * @return will return the number of things between those parameters.
     */
    public int countRage(Beer start, Beer end) {
        int count = 0;
        BeerNode cursor = head;
        while (cursor != null) {
            int comparedStart = cursor.getData().compareTo(start);
            int compareToEnd = cursor.getData().compareTo(end);
            if (comparedStart >= 0 && compareToEnd <= 0)
                count++;
            cursor = cursor.getLink();
        }
        return count;
    }
    /**
     * method to grab a beer at an index.
     * @param index requires the index of the beer you are grabbing.
     * @return This will return the data of the node, or null.
     */
    public Beer grab(int index) {
        BeerNode cursor = head;
        int target = 0;
        while (cursor != null) {
            if (target == index) {
                return cursor.getData();
            }
            target++;
            cursor = cursor.getLink();
        }
        return null;
    }
    /**
     * this is the method that I created, that will allow me test and grab a node.
     * @param index requires an index of a node.
     * @return and will return a node.
     */
    public BeerNode grabNode(int index) {
        BeerNode cursor = head;
        int target = 0;
        while (cursor != null) {
            if (target == index) {
                return cursor;
            }
            target++;
            cursor = cursor.getLink();
        }
        return null;
    }
    /**
     * eturns the index of the node that contains the target
     * where the first node (referenced by head) is at index
     * @param target requires a target.
     * @return will return a compareTo number.
     */
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
    /**
     *Replaces the beer element at the spcefic index that you want it to be in. If the index is beyond
     * or negative this method does nothing. The list starts at index 0.
     * @param index needs the index you want to replace.
     * @param element also needs the element that you are trying to replace.
     */
    public void set(int index, Beer element) {
        BeerNode cursor = head;
        if (manyItems > index && index >= 0) {
            //while (index != null){
            for (int i = 0; i < index; i++) {
                if (i == (index - 1)) {
                    cursor.addBeerNodeAfter(element);
                } else {
                    cursor = cursor.getLink();
                }
            }
        }
    }
    /**
     * This method will replace one occurrence of the Beer youre looking for.
     * @param oldBeer requires old beer to replace.
     * @param newBeer requires new beer to replace.
     * @return will return a true or false.
     */
    public boolean replace(Beer oldBeer, Beer newBeer){
        BeerNode cursor = head;
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
    /**
     * this method will return the sum of all the ratings of the beer.
     * @return the sum of all ratings.
     */
    public int totalValue(){
        BeerNode cursor = head;
        int sum = 0;
        while (cursor!= null) {
            sum = sum + cursor.getData().getRating();
            cursor = cursor.getLink();
        }
        return sum;
    }
    /**
     * Method will calculate all the Beers less than or equal to the element.
     * @param element requires a beer to make comparison.
     * @return will return a BeerNode.
     */
    public BeerNode lessThan(Beer element){
        BeerLinkedBag list = new BeerLinkedBag();
        BeerNode cursor = head;
        while (cursor!= null){
            if(cursor.getData().compareTo(element) <= 0){
                list.add(cursor.getData());
            }
            cursor = cursor.getLink();
        }
        return list.head;
    }
    /**
     * Method will generate a linked list that will show all the nodes that have
     * a rating greater than the Beer you feed it.
     * @param element requires a beer.
     * @return will return a head of a linked list.
     */
    public BeerNode greaterThan(Beer element){
        BeerLinkedBag list2 = new BeerLinkedBag();
        BeerNode cursor = head;
        while (cursor!= null){
            if(cursor.getData().compareTo(element) < 0){
                list2.add(cursor.getData());
            }
            cursor = cursor.getLink();
        }
        return list2.head;
    }

    /**
     *Method will return that max rating in the linked list.
     * @return will return a Beer Object-The max.
     */
    public Beer getMax(){
        BeerNode cursor = head;
        Beer maxFoundSoFar = head.getData();
        while(cursor !=null) {
            if(cursor.getData().compareTo(maxFoundSoFar) >= 1){
                maxFoundSoFar = cursor.getData();
            }
            cursor = cursor.getLink();
        }
        return maxFoundSoFar;
    }
    /**
     * Method will return the minumum rating of all the beers in the list.
     * @return will return a beer object.
     */
    public Beer getMin(){
        BeerNode cursor = head;
        Beer minFoundSoFar = head.getData();
        while(cursor !=null) {
            if(cursor.getData().compareTo(minFoundSoFar) < 0) {
                minFoundSoFar = cursor.getData();
            }
            cursor = cursor.getLink();
        }
        return minFoundSoFar;
    }
}
