/**
 *A Class for A Collection of Beers that I have tried.
 */
public class Beer {
    private int rating;
    private String brand;
    private String name = "";

    /**
     *Getter for rating
     * @return a integer
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets the rating.
     * @param rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Gets the search for the Beer, im searching for.
     * @return will return a string.
     */
    public String getBrand() {
        return brand;
    }

    /**
     *Will ser the search key for the searchKey
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Gets the name of the beer
     * @return a String.
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the beer.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * THIS METHOD NEEDS WORK. I DONT KNOW HOW TO FORMAT STRINGS!
     * @return
     */
    @Override
    public String toString(){
        String str = String.format("%s\t%s\t%d\t", name, brand, rating);
        return str;
    }

    /**
     * This method checks the searchkey(NAME, and checks for duplicates).
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj){
        boolean output = false;
        if(obj instanceof Beer){
            Beer otherBeer = (Beer) obj;
            output = otherBeer.name.equalsIgnoreCase(this.name);
        }
        return output;
    }
}
