import java.util.Queue;
import java.util.LinkedList;

public class Washer {

    private int minutesForWash;
    private int washTimeLeft;

    public Washer(int s) {
        minutesForWash = s;
        washTimeLeft = 0;
    }

    public boolean isBusy()	{
        return (washTimeLeft > 0);
    }

    public void reduceRemainingTime()	{
        if (washTimeLeft > 0)
            washTimeLeft--;
    }

    public void startWashing()	{
        if (washTimeLeft > 0)
            throw new IllegalStateException("Washer is already busy");
        washTimeLeft = minutesForWash;
    }

	/* Exponential distribution
	public double getNext() {
	    return  Math.log(1-rand.nextDouble())/(-lambda);
	}
	*/

    public static void carWashSimulate(int washTime, double arrivalProb, int totalTime)	{
        Queue<Integer> arrivalTimes = new LinkedList<Integer>();
        int next;

        BooleanSource arrival = new BooleanSource (arrivalProb);
        Washer machine = new Washer(washTime);
        Averager waitTimes = new Averager();
        int currentMinute;

        System.out.println ("Minutes to wash one car: " + washTime);
        System.out.print("Probability of customer arrival during a minute: ");
        System.out.println(arrivalProb);
        System.out.println("Total simulation minutes: " + totalTime);

        if (washTime <= 0 || arrivalProb < 0 || arrivalProb > 1 || totalTime < 0)
            throw new IllegalArgumentException ("Values out of range");
        for (currentMinute = 0; currentMinute < totalTime; currentMinute++)	{
            if (arrival.query())
                arrivalTimes.add(currentMinute);

            if ((!machine.isBusy()) && (!arrivalTimes.isEmpty()))	{
                next = arrivalTimes.remove();
                waitTimes.addNumber(currentMinute - next);
                machine.startWashing();
            }

            machine.reduceRemainingTime();
        }

        System.out.println("Customers served: " + waitTimes.howManyNumbers());
        if (waitTimes.howManyNumbers() > 0)
            System.out.println("Average wait: " + waitTimes.average() + " sec");
    }

    public static void main(String[] args)	{
        Washer.carWashSimulate(1, 0.7, 100000);
        System.out.println ("---------------------");
        Washer.carWashSimulate(10, 0.7, 100000);
        System.out.println ("---------------------");
        Washer.carWashSimulate(1, 1, 100000);
        System.out.println ("---------------------");
        Washer.carWashSimulate(10, 1, 100000);
    }
}