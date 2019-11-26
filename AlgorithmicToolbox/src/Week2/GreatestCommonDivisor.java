package Week2;

import java.util.Scanner;

public class GreatestCommonDivisor{
	private static int computeGCD(int a, int b) {
		int gcd = 0;
		if (b == 0) {
			gcd = a;
		}
		else{
			int a_prime = a%b;
			gcd = computeGCD(b, a_prime);
		}
		return gcd;
	}
	public static void main(String[]args) {
		Scanner s = new Scanner(System.in);
		int a =  s.nextInt();
		int b = s.nextInt();
		System.out.println("The GCD is " + computeGCD(a,b));
		s.close();
	}
}