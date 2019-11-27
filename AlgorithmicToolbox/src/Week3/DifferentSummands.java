package Week3;
import java.util.*;
public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int remaining = n;
    	for (int i=1; i<=n; i++) {
    		if (remaining-i < i+1) {
    			summands.add(remaining);
    			break;
    		}
    		remaining -= i; 
    		summands.add(i);	
    	}
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

