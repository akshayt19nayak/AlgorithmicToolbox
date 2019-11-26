package Week2;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciNth {
	public static boolean[] inductive(int range) {
		boolean[] conditional = new boolean[range];
		for(int n=0; n<range; n++) {
			double lhs = Math.pow(2,(((double)(n)-1)/2)) + Math.pow(2,(((double)(n)-2)/2));
			double rhs = Math.pow(2,((double)n)/2);
			//System.out.println("The lhs value is " + lhs);
			//System.out.println("The rhs value is " + rhs);
			conditional[n] = lhs > rhs;
		}
		return conditional;
	}
	public static double approxNthFibo(int n) {
		return Math.pow(2, n/2);
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
	public static double formulaFibo(int n) {
		double first_term = Math.pow((1 + Math.sqrt(5))/2, n);
		double second_term = Math.pow((1 - Math.sqrt(5))/2, n);
		double fibo = Math.sqrt(1/5)*(first_term - second_term);
		return fibo;
	}
	public static long fibRecurs(int n) {
		if ((n <= 1) && (n >= 0)) {
			return (long) n;
		}
		else if (n > 1) {
			return (fibRecurs(n-1) + fibRecurs(n-2));
		}
		return 0;
	}
	public static void main(String[]args) {
		Scanner s = new Scanner(System.in);
		//int range =  s.nextInt();
		int n = s.nextInt();
		//boolean[] conditional = inductive(range);
		//System.out.println(Arrays.toString(conditional));
        System.out.println("n starts from 0");
        System.out.println("The nth fibonacci number is greater than/equal to " + approxNthFibo(n));
        //System.out.println("The actual fibonacci number by recursion is " + fibRecurs(n));
        System.out.println("The actual fibonacci number by formula is " + calcFibo(n));
        s.close();
	}
}