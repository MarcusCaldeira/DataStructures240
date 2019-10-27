import java.util.Queue;
import java.util.LinkedList;

public class Runway{

    private int minutesForLanding;
    private int minutesForTakeoff;
    private int minutesLeft;

    public Runway(int l, int t) {
        this.minutesForLanding = l;
        this.minutesForTakeoff = t;
        this.minutesLeft = 0;
    }

    public boolean isBusy()	{
        return (minutesForTakeoff > 0);
    }

    public void reduceRemainingTime()	{
        if (minutesForTakeoff > 0)
            minutesForTakeoff--;
    }
    public void startService(int type){
        if(minutesLeft > 0){
            throw new IllegalStateException("Runway is busy");
        }else if(type == 1){
            minutesLeft = minutesForLanding;
        }if(type == 0){
            minutesLeft = minutesForTakeoff;
        }
    }

    public static void simulate(int landingTime, int takeOffTime, double landingProb, double takeoffProb, int totalTime)	{
        Queue<Integer> arrivalTimes = new LinkedList<Integer>();
        Queue<Integer> departureTimes = new LinkedList<Integer>();
        int next;

        BooleanSource arrival = new BooleanSource (landingProb);
        BooleanSource takeOff = new BooleanSource (takeoffProb);
        //Single Runway
        Runway runway = new Runway(landingTime, takeOffTime);
        //Double Runway
        Runway runwayTwo = new Runway(landingTime, takeOffTime);
        Averager averageWaitTimeForLanding = new Averager();
        Averager averageWaitTimeForTakeOff = new Averager();
        int currentMinute;

        System.out.println ("Minutes to service one plane " + landingTime);
        System.out.print("Probability of a plane arrival during a minute: ");
        System.out.println(landingProb);
        System.out.println("Total simulation minutes: " + totalTime);

        if (landingTime <= 0 || landingProb < 0 || landingProb > 1 || totalTime < 0)
            throw new IllegalArgumentException ("Values out of range");
        for (currentMinute = 0; currentMinute < totalTime; currentMinute++)	{
            if (arrival.query()){
                arrivalTimes.add(currentMinute);
            }if (takeOff.query()){
                departureTimes.add(currentMinute);
            }
            //"Remember that landings take precedence over takeoffs"
            if ((!runway.isBusy()) && (!arrivalTimes.isEmpty()) )	{
                //we remove the landing plane and place it into next.
                next = arrivalTimes.remove();
                //As the plane is landing we remove it from the arrival(always check if there is another plane.)
                averageWaitTimeForLanding.addNumber(currentMinute - next);
                runway.startService(0);
            }
            else if((!runway.isBusy()) && (!arrivalTimes.isEmpty())){
                next = departureTimes.remove();
                averageWaitTimeForTakeOff.addNumber(currentMinute-next);
                runway.startService(1);
            }
            runway.reduceRemainingTime();
        }

        System.out.println("Planes Serviced: " + averageWaitTimeForLanding.howManyNumbers());
        if (averageWaitTimeForLanding.howManyNumbers() > 0)
            System.out.println("Average wait: " + averageWaitTimeForLanding.average() + " sec");
    }

    public static void main(String[] args)	{
        Runway.simulate(2, 3, .45, .000000001,100000);
        System.out.println ("---------------------");
    }






}