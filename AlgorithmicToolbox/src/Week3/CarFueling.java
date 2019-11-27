package Week3;
import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {  
    	//Create an ArrayList so that you can add elements from the stops array
    	ArrayList<Integer> trips = new ArrayList<Integer>();
    	trips.add(0);
    	for (int i : stops) {
    	    trips.add(i);
    	}
    	trips.add(dist);
    	//System.out.println(trips);
    	int numRefills = 0;
    	int currentRefill = 0;
        int totalRefills = stops.length;
    	while(currentRefill<=totalRefills) {
    		int lastRefill = currentRefill;
    		while((currentRefill <= totalRefills) && ((trips.get(currentRefill + 1) - trips.get(lastRefill)) <= tank)){
	    		currentRefill = currentRefill + 1;
	    	}
	    	if (currentRefill == lastRefill) {
	    		return -1;
	    	}
	    	if (currentRefill <= totalRefills) {
	    		numRefills = numRefills + 1;
	    	}
	    	//System.out.println(lastRefill + " " + currentRefill);
    	}
    	return numRefills;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
