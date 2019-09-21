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
    public void insert(String name, String brand, int rating){
        Beer newBeer = new Beer();
        newBeer.setName(name);
        newBeer.setBrand(brand);
        newBeer.setRating(rating);
        data[manyItems] = newBeer;
        manyItems++;
    }
    public int size(){
        return this.manyItems;
    }
    @Override
    public String toString(){
        String str = String.format("%-15s\t%-15s\t%-15s\n--------------------------------------\n", "Name", "Brand", "Rating");
        for(int i = 0; i < manyItems; i++)
            str += String.format("%-15s\t%-15s\t%-15d\n",data[i].getName(),data[i].getBrand(),data[i].getRating());

        return str;
    }
    public void display(String displayAllBeers){

    }


}
