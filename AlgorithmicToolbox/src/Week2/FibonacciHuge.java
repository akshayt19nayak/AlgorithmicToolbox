package Week2;
import java.util.*;

/* 
1. Generate Fibonacci number modulo m
2. Append it to an ArrayList
3. Stop generating if the current modulus is a 1 and the previous modulus is a 0
4. Calculate the size of the ArrayList
5. Divide the given Fibo number with size and calculate modulo
6. Index the ArrayList at that modulo and return it 
*/


public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
           		
        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }
        //System.out.println(current);
        return current % m;
    }
    private static long getModulus(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        
        long first_pisano = 0;
        long second_pisano = 1;
        long temp_modulus = second_pisano;
        		
        ArrayList<Long> period =  new ArrayList<>();
        period.add(first_pisano);
        period.add(second_pisano);
        
        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % m;
            long current_modulus = current;
            if ((current_modulus==1) && (temp_modulus==0)) {
            	period.remove(period.size()-1);
            	break;
            }
            else {
            	period.add(current_modulus);
            	temp_modulus = current_modulus;
            }
        }
        //System.out.println(period);
        int lenPeriod = period.size();
        int index = indexModulus(n, lenPeriod);
        //System.out.println(index);
        long modulus = period.get(index);
        return modulus;
    }
    private static int indexModulus(long n, int lenPeriod) {
    	int index = (int)(n % lenPeriod);
    	return index;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        //System.out.println(getFibonacciHugeNaive(n, m));
        System.out.println(getModulus(n, m));
        //scanner.close();
    }
}

