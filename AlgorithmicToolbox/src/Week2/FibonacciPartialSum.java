package Week2;
import java.util.*;
public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
            	System.out.println(current % 10);
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current; 
        }
        return sum % 10;
    }
    private static int getFibonacciPartialSumLastDigit(long from, long to) {
    	if (to <= 1)
            return (int)to;

        int previous = 0;
        int current  = 1;
        ArrayList<Integer> currentLastDigit = new ArrayList<Integer>();
        currentLastDigit.add(previous);
        currentLastDigit.add(current);
        int repeatsAt = 59;
        for (int i = 0; i < repeatsAt - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%10;
            currentLastDigit.add(current);
        }
        int lenCurrentLastDigit = currentLastDigit.size();
        int first_index = indexLastDigit(from, lenCurrentLastDigit);
        int second_index = indexLastDigit(to, lenCurrentLastDigit);
        int sum = 0;
        if (second_index >= first_index) {
        	for (int i=first_index; i<=second_index; i++) {
            	sum += currentLastDigit.get(i);
            }
        }
        else {
        	for (int i=first_index; i<=(lenCurrentLastDigit + second_index); i++) {
        		//System.out.println(sum);
        		if (i >= lenCurrentLastDigit) {
            		sum += currentLastDigit.get(i - lenCurrentLastDigit);
            	}
            	else {
            		sum += currentLastDigit.get(i);
            	}
            }
        }
        //Code for debugging 
        return sum%10;
    }    
    private static int indexLastDigit(long n, int lenCurrentLastDigit) {
    	int index = (int)(n % lenCurrentLastDigit);
    	return index;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        //System.out.println("Value is " + getFibonacciPartialSumNaive(from, to));
        System.out.println(getFibonacciPartialSumLastDigit(from, to));
    }
}

