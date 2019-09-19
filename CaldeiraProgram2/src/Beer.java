/**
 *A Class for A Collection of Beers that I have tried.
 */
public class Beer {
    private int aggregateInformation;
    private String searchKey;
    private String Name = "";

    /**
     *Getter for aggregateInformation
     * @return a integer
     */
    public int getAggregateInformation() {
        return aggregateInformation;
    }

    /**
     * Sets the aggregate information
     * @param aggregateInformation
     */
    public void setAggregateInformation(int aggregateInformation) {
        this.aggregateInformation = aggregateInformation;
    }

    /**
     * Gets the search for the Beer, im searching for.
     * @return will return a string.
     */
    public String getSearchKey() {
        return searchKey;
    }

    /**
     *Will ser the search key for the searchKey
     * @param searchKey
     */
    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    /**
     * Gets the name of the beer
     * @return a String.
     */
    public String getName() {
        return Name;
    }

    /**
     * sets the name of the beer.
     * @param name
     */
    public void setName(String name) {
        Name = name;
    }
    @Override

}
