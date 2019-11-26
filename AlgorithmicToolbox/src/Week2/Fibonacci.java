package Week2; 
import java.util.*;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;
    return calc_fib(n - 1) + calc_fib(n - 2);
  }
  private static long calcFibo(int n) {
	  long fibo = 0;
	  if ((n>=0)&&(n<=1)) {
		  fibo = (long)n;
		  return fibo;
		}
		//0,1,1,2,3,5,8
		int prev = 0;
		int current = 1;
		if (n>1) {
			for (int j = 2; j <= n; j++) {
				int new_current = prev + current;
				prev = current;
				current = new_current;
			}
			fibo = current;
		}
		
		return fibo;
	}
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    long fibo = calcFibo(n);
    //System.out.println(calc_fib(n));
    System.out.println(fibo);
  } 
}
