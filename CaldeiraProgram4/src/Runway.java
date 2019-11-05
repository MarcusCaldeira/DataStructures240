import java.util.LinkedList;
import java.util.Queue;

public class Runway {

	private int minutesForLanding; //minutes it takes for a plane to land
	private int minutesForTakeoff; //minutes it takes for a plane to takeoff
	private int serviceTimeLeft = 0; //how much time it takes to service a landing or departing plane

	/**
	 *
	 * @param l
	 * @param t
	 */
	public Runway(int l, int t) { //Constructor which handles initializing the
		//minutes landing/takeoff instance variables
		minutesForLanding = l;
		minutesForTakeoff = t;
	}

	/**
	 *
	 * @return serviceTimeLeft - time left to complete a plane
	 */
	public boolean isBusy()	{ //boolean method which finds out if the aiport is busy or not
		return (serviceTimeLeft > 0);
	}

	public void reduceRemainingTime()	{
		if (serviceTimeLeft > 0)
			serviceTimeLeft--;
	}

	public void startService(int serviceType)	{
		if (serviceTimeLeft > 0)
			throw new IllegalStateException("Runways is already busy");
		if (serviceType == 1) { //double check service values
			serviceTimeLeft = minutesForLanding;
		}else if (serviceType == 0) {
			serviceTimeLeft = minutesForTakeoff;
		}
	}



	public static boolean isFreeRunway(Runway[] runways){
		boolean anyFree = false;

		for (int i = 0; i < runways.length; i++)
			anyFree = anyFree || ! runways[i].isBusy();
		return anyFree;
	}
	public static Runway getFreeRunway(Runway[] runways) {
		if (!runways[0].isBusy())
			return runways[0];
		else
			return runways[1];

	}
	public static void runwaySimulate(int timeToLand, int timeToTakeOff, double arrivalRate,
									  double departureRate, int remainingFuel, int numberOfRunways, int simulationTime)	{
		Runway[] runways = new Runway[numberOfRunways];
		Queue<Integer> arrivalTimes = new LinkedList<Integer>();
		Queue<Integer> departureTimes = new LinkedList<Integer>();

		int next;
		int crashed = 0;

		BooleanSource arrival = new BooleanSource (arrivalRate);
		BooleanSource departure = new BooleanSource (departureRate);
		// init both runways
		for(int i=0;i<numberOfRunways;i++)
			runways[i] = new Runway(timeToLand, timeToTakeOff);

		Averager avgWaitTimeForLanding = new Averager();
		Averager avgWaitTimeForDeparture = new Averager();

		int currentMinute;

		System.out.println ("Minutes it takes to land one plane: " + timeToLand);
		System.out.println ("Minutes it takes to depart one plane: " + timeToTakeOff);
		System.out.print("Probability of plane arrival in a minute: ");
		System.out.println( (float) arrivalRate);
		System.out.print("Probability of plane departure in a minute: ");
		System.out.println((float)departureRate);
		System.out.println("Total simulation minutes: " + simulationTime);

		if (timeToLand <= 0 || arrivalRate < 0 || arrivalRate > 1 || timeToTakeOff <= 0 || departureRate < 0 || departureRate > 1 || simulationTime < 0)
			System.out.println("Values out of range");
		for (currentMinute = 0; currentMinute < simulationTime; currentMinute++)	{
			if (arrival.query()) {
				arrivalTimes.add(currentMinute); //add the time arrival plane arrives in the queue
			}
			if (departure.query()) {
				departureTimes.add(currentMinute); //add the time the departure plane departs the queue
			}
			//this is checking when the run way is busy and a plan is waiting to processed
			while ((isFreeRunway(runways)) && (!arrivalTimes.isEmpty()))	{
				next = arrivalTimes.remove(); //remove plane from arrival queue - time they arrived
				int waitTime = currentMinute - next; //how long waited
				if (waitTime > remainingFuel) {
					crashed++; //if here we've crashed
				}else {
					avgWaitTimeForLanding.addNumber(waitTime);
					Runway runway = getFreeRunway(runways);
					runway.startService(1); //start the service
				}
			}

			//no planes landing
			if ((isFreeRunway(runways)) && !departureTimes.isEmpty()) {
				next = departureTimes.remove();
				avgWaitTimeForDeparture.addNumber(currentMinute - next);
				Runway runway = getFreeRunway(runways);

				runway.startService(0);
			}
			for(int i=0;i<numberOfRunways; i++)
				runways[i].reduceRemainingTime(); //mins goes by
		}

		System.out.println("Planes arrived: " + avgWaitTimeForLanding.howManyNumbers());
		System.out.println("Planes departed: " + avgWaitTimeForDeparture.howManyNumbers());
		if (avgWaitTimeForLanding.howManyNumbers() > 0 || avgWaitTimeForDeparture.howManyNumbers() > 0) {
			System.out.println("Average wait for arrival: " + (int) avgWaitTimeForLanding.average() + " min");
			System.out.println("Average wait for departure: " + (int) avgWaitTimeForDeparture.average() + " min");
			System.out.println("Number of crashes: " + crashed);
		}
	}
}


