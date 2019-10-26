import java.util.Queue;
import java.util.LinkedList;

public class Runway{

    private int minutesForLanding;
    private int minutesForTakeoff;

    public Runway(int s) {
        minutesForLanding = s;
        minutesForTakeoff = 0;
    }

    public boolean isBusy()	{
        return (minutesForTakeoff > 0);
    }

    public void reduceRemainingTime()	{
        if (minutesForTakeoff > 0)
            minutesForTakeoff--;
    }
    public void startService(int type){

        if(minutesForLanding == 1){
            minutesForLanding = type;
        }if (minutesForTakeoff == 0){
            minutesForTakeoff = type;
        }

    }

    public static void simulate(int landingTime, double arrivalProb, int totalTime)	{
        Queue<Integer> arrivalTimes = new LinkedList<Integer>();
        int next;

        BooleanSource arrival = new BooleanSource (arrivalProb);
        Runway runway = new Runway(landingTime);
        Averager waitTimes = new Averager();
        int currentMinute;

        System.out.println ("Minutes to service one plane " + landingTime);
        System.out.print("Probability of a plane arrival during a minute: ");
        System.out.println(arrivalProb);
        System.out.println("Total simulation minutes: " + totalTime);

        if (landingTime <= 0 || arrivalProb < 0 || arrivalProb > 1 || totalTime < 0)
            throw new IllegalArgumentException ("Values out of range");
        for (currentMinute = 0; currentMinute < totalTime; currentMinute++)	{
            if (arrival.query())
                arrivalTimes.add(currentMinute);
            //if the runway is free and if its busy(somebody is waiting to be serviced)
            if ((!runway.isBusy()) && (!arrivalTimes.isEmpty()))	{
                next = arrivalTimes.remove();
                waitTimes.addNumber(currentMinute - next);
                runway.startService(0);
            }

            runway.reduceRemainingTime();
        }

        System.out.println("Customers served: " + waitTimes.howManyNumbers());
        if (waitTimes.howManyNumbers() > 0)
            System.out.println("Average wait: " + waitTimes.average() + " sec");
    }

    public static void main(String[] args)	{
        Runway.simulate(1, 0.7, 100000);
        System.out.println ("---------------------");
        Runway.simulate(10, 0.7, 100000);
        System.out.println ("---------------------");
        Runway.simulate(1, 1, 100000);
        System.out.println ("---------------------");
        Runway.simulate(10, 1, 100000);
    }
}