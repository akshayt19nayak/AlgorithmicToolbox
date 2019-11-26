package Week2;
import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }
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
  private static long computeLCM(int a, int b) {
	    int gcd = computeGCD(a, b);
	    long product = ((long)a)*b;
	    return product/gcd;
	  }
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(computeLCM(a, b));
  }
}
