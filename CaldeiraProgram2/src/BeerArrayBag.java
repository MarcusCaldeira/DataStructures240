/**
 *This is the collection class, This bag contains numerous Beers.
 * and will display them in a nicely formatted way.
 */
public class BeerArrayBag {
    private Beer[] data;
    private int manyItems;
    /**
     * Method to initialize the bag.
     * @param size an array of Beers.
     */
    public BeerArrayBag(int size) {
        this.data = new Beer[size];
        this.manyItems = 0;
    }

    /**
     *This method instantiates, the Beer Object.
     * @param name String.
     * @param brand String.
     * @param rating Int.
     */
    public void insert(String name, String brand, int rating){
        if (manyItems >= data.length){ // the data array is already full
            return;
        }
        Beer newBeer = new Beer();
        newBeer.setName(name);
        newBeer.setBrand(brand);
        newBeer.setRating(rating);
        data[manyItems] = newBeer;
        for(int i = 0; i < manyItems; i++){
            if(data[i].compareTo(newBeer) < 0){
                i++;
            }
            if(data[i] == null){ // if the current position is empty add it here
                data[i] = newBeer;
                break;
            }else{ // move all remaining items up one index
                for (int j = manyItems -1; j >= i; j--){
                    data[j+1]= data[j];
                }
                data[i] = newBeer;
                break;
            }
        }
        manyItems++; // increase the count of items in the bag
    }

    /**
     *This method returns the number of objects in the collection.
     * @return An array of the items in the collection.
     */
    public int size(){
        return this.manyItems;
    }

    /**
     *Override toString method that prints out the correctly formatted version of a list.
     * @return a string.
     */
    @Override
    public String toString(){
        String str = String.format("%-15s\t%-15s\t%-15s\n--------------------------------------\n", "Name", "Brand", "Rating");
        for(int i = 0; i < manyItems; i++)
            str += String.format("%-15s\t%-15s\t%-15d\n",data[i].getName(),data[i].getBrand(),data[i].getRating());

        return str;
    }

    /**
     *This method, will correctly show the Search key of what youre searching for.
     * In my case you can search by beerBrand.
     * @param beerBrand
     */
    public void display(String beerBrand){
        System.out.printf("%-15s\t%-15s\t%-15s\n--------------------------------------\n", "Name", "Brand", "Rating");
        for(int i = 0; i < manyItems; i++)
            if(data[i].getBrand().equalsIgnoreCase(beerBrand)){
                System.out.printf("%-15s\t%-15s\t%-15s\n--------------------------------------\n",data[i].getName(),data[i].getBrand(),data[i].getRating());
            }
    }
    /**
     *This method gathers the number of items that have the
     * search key.
     * @param key A string.
     * @return returns an Int called count(which is the number of items in the count
     * that have the search key.
     */
    public int countOccurrences(String key){
        int count = 0;
        for(int i = 0; i < manyItems; i++){
            if(data[i].getBrand().equalsIgnoreCase(key))
                count++;
        }
        return count;
    }
    /**
     *Method to determine if the collection
     * contains at least one beer.
     * @param beer2 an object of Beer.
     * @return a boolean.
     */
    public boolean contains(Beer beer2){
        for(int i = 0; i < manyItems; i++){
            if(data[i].equals(beer2)){
                return true;
            }
        }
        return false;
    }
    /**
     *This method calculates the sum,
     * of all the ratings inside the Beer Class.
     * @return int sum of rating.
     */
    public int total(){
        int sum = 0;
        for(int i = 0; i < manyItems; i++){
            sum += data[i].getRating();
        }
        return sum;
    }
    /**
     *This method takes in two numbers that count as
     * the range, then it will populate how many items of the list
     * are within that range.
     * @param bottomRange the lower of the range.
     * @param topRange the higher number of the range.
     * @return returns an int of the count inside the collection.
     */
    public int countRange(int bottomRange, int topRange){
        int count = 0;
            for (int i = 0; i < manyItems; i++){
                if(data[i].getRating() >= bottomRange && data[i].getRating()<= topRange)
                    count++;
            }
            return count;
    }
    /**
     *Method takes the
     * @param target Beer object that you want to delete.
     * @return a boolean.
     */
    public boolean delete(Beer target){
        for(int i = 0; i < manyItems; i++){
            if(data[i].equals(target)){
                for (int j = i; j < manyItems; j++){
                    data [j] = data[j + 1];
                }
                this.manyItems --;
                return true;
            }
        }
        return false;
    }

}
