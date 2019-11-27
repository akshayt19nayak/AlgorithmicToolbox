package Week3;
import java.util.Scanner;
import java.util.Arrays;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
    	//Calculate proportions
    	//Write helper method argMax to find index of highest value of proportion
    	//argMax returns -1 if max value (consequently all values) = 0
    	//While capacity != 0, choose proportion and weight at argMax
    	//Take a minimum(capacity, weight at argMax) and decrement capacity by that much 
    	//Increment value by a multiple of proportion at argMax and weight at argMax
    	//Set proportion at argMax to 0
    	double value = 0;
        double[] proportions = new double[values.length];
        for(int i=0; i<values.length;i++) {
        	proportions[i] = ((double)values[i])/weights[i];
        }
        //System.out.println(Arrays.toString(proportions));
        while (capacity != 0) {
        	int bestIndex = argMax(proportions);
        	if (bestIndex == -1) {
        		break;
        	}
        	double highestProp = proportions[bestIndex];
        	int highestPropWeight = weights[bestIndex];
        	
        	int weight = Math.min(capacity, highestPropWeight);
        	
        	capacity = capacity - weight; //Decrement capacity
        	value = value + highestProp*weight; //Increment value
        	//weights[bestIndex] = weights[bestIndex] - weight; //Decrement weight
        	proportions[bestIndex] = 0; //Don't consider this proportion
        }
        return value;
    }
    private static int argMax(double[] array) {
    	int maxIndex = 0;
    	for(int i=0; i<array.length; i++) {
    		if (array[i] >= array[maxIndex]) {
    			maxIndex = i;
    		}
    	}
    	if (array[maxIndex] == 0) {
    		return -1;
    	}
    	return maxIndex;
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
