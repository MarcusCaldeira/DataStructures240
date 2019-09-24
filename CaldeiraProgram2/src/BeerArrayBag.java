/**
 *
 */
public class BeerArrayBag {
    private Beer[] data;
    private int manyItems;
    /**
     * @param size
     */
    public BeerArrayBag(int size) {
        this.data = new Beer[size];
        this.manyItems = 0;
    }

    /**
     *
     * @param name
     * @param brand
     * @param rating
     */
    public void insert(String name, String brand, int rating){
        Beer newBeer = new Beer();
        newBeer.setName(name);
        newBeer.setBrand(brand);
        newBeer.setRating(rating);
        data[manyItems] = newBeer;
        manyItems++;
    }

    /**
     *
     * @return
     */
    public int size(){
        return this.manyItems;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        String str = String.format("%-15s\t%-15s\t%-15s\n--------------------------------------\n", "Name", "Brand", "Rating");
        for(int i = 0; i < manyItems; i++)
            str += String.format("%-15s\t%-15s\t%-15d\n",data[i].getName(),data[i].getBrand(),data[i].getRating());

        return str;
    }

    /**
     *
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
     *
     * @param key
     * @return
     */
    public int countOccurrences(String key){
        int count = 0;
        for(int i = 0; i < manyItems; i++){
            if(data[1].getBrand().equalsIgnoreCase(key))
                count++;
        }
        return count;
    }

    /**
     *
     * @param beer2
     * @return
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
     *
     * @return
     */
    public int total(){
        int sum = 0;
        for(int i = 0; i < manyItems; i++){
            sum += data[i].getRating();
        }
        return sum;
    }

    /**
     *
     * @param bottomRange
     * @param topRange
     * @return
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
     *
     * @param target
     * @return
     */
    public boolean delete(Beer target){
        for(int i = 0; i < manyItems; i++){
            if(data[i].equals(target)){
                this.data[i] = this.data[manyItems-1] ;
                this.manyItems --;
                return true;
            }
        }
        return false;
    }

}
