/**
 * Defining an object that will be used in a collection class.
 * The Beer Class has three private variables, the rating, the brand, and the name.
 * Methods are used in the BeerArrayBag Class.
 */
public class Beer implements Comparable <Beer>{
    private int rating;
    private String brand;
    private String name = "";

    /**
     *Getter or Rating.
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
     *Method will set the Brand.
     * @param brand String.
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
     * @param name String.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns a nicely formatted object.
     * @return a string.
     */
    @Override
    public String toString(){
        String str = String.format("%s\t%s\t%d\t", name, brand, rating);
        return str;
    }
    /**
     * This method checks the searchkey(NAME, and checks for duplicates).
     * @param obj Taking a generic object from object class, and comparing if its
     *            an instance of the Beer object in combination with a equalsIgnoreCase.
     * @return A Boolean that is false.
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
    /**
     * Compares two beers by comparing their brands. Results reflect
     * case insensitive alphabetical ordering.
     * @param beer Beer for comparison
     * @return int -1 if this.brand < beer.brand.
     * 0 if this.brand == beer.brand
     * 1 if this.brand > beer.brand
     */
    @Override
    public int compareTo(Beer beer) {
        return this.brand.compareToIgnoreCase(beer.brand);
    }
}
