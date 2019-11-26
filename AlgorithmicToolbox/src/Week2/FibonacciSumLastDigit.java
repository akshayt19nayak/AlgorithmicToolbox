package Week2;
import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current);
            sum += current;
        }

        return sum % 10;
    }
    private static int getFibonacciSumLastDigit(long n) {
    	if (n <= 1)
            return (int)n;

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
        int index = indexLastDigit(n, lenCurrentLastDigit);
        int sum = 0;
        for (int i=0; i<=index; i++) {
        	current = currentLastDigit.get(i)%10;
        	sum = (sum + current)%10;
        }
        return sum;
    }     
    private static int indexLastDigit(long n, int lenCurrentLastDigit) {
    	int index = (int)(n % lenCurrentLastDigit);
    	return index;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        //long s = getFibonacciSumNaive(n);
        int t = getFibonacciSumLastDigit(n);
        //System.out.println(s);
        System.out.println(t);
    }
}

