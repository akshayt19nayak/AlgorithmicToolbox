package Week3;
import java.util.Scanner;

public class Change {
	private static int getChange(int m) {
        //Set a counter for the number of coins needed to 0 ==> numCoins
		//Start with coins of denomination 10 and progress to smaller denominations
		//Decrement m and increase numCoins
		int numCoins = 0;
		int[] denominations = {10,5,1};
		while (m != 0) {
			for(int denom:denominations) {
				int coins = calcQuotient(m, denom);
				m = m - denom*coins;
				numCoins += coins;
			}
		}
        return numCoins;
    }
	private static int calcQuotient(int value, int denomination) {
		return value/denomination;
	}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}

