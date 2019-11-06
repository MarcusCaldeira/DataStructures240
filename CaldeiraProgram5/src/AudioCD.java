public class AudioCD extends SalesItem {
    protected String label;
    protected int playingTime;

    public AudioCD(int code, double price, int quantity, String label, int playingTime) {
        super(code, price, quantity);
        this.label = label;
        this.playingTime = playingTime;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(int playingTime) {
        this.playingTime = playingTime;
    }
    @Override
    public void monthlyPromo() {
        double currentPrice = this.getPrice()-(this.getPrice() * 0.05);
        this.setPrice(currentPrice);

    }
    @Override
    public String toString(){
        String str = String.format("%s	%s	%d	",super.toString(),label,playingTime);
        return str;
    }
}
