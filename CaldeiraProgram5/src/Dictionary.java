public class Dictionary extends Book {
    protected String language;
    protected int numDefinition;

    public Dictionary(int code, double price, int quantity, String author, int numPages, String language, int numDefinition) {
        super(code, price, quantity, author, numPages);
        this.language = language;
        this.numDefinition = numDefinition;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getNumDefinition() {
        return numDefinition;
    }

    public void setNumDefinition(int numDefinition) {
        this.numDefinition = numDefinition;
    }
    @Override
    public String toString(){
        String str = String.format("%s	%s	%d	",super.toString(),language,numDefinition);
        return str;
    }
    public double getRatio(){
        double ratio = this.getNumDefinition()/super.getNumPages();
        return ratio;
    }

}
