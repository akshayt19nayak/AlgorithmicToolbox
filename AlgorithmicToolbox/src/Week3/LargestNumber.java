package Week3;
import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        ArrayList<String> digits = new ArrayList<String>();
        for (String s:a) {
        	digits.add(s);
        }
    	String result = "";
        while (digits.size() != 0) {
        	int maxIndex = max(digits); 
        	String maxValue = digits.get(maxIndex);
        	result += maxValue;
        	digits.remove(maxIndex);
        }
        return result;
    }
    public static int max(List<String> array){
    	int maxIndex = 0;
    	for(int i=0; i<array.size(); i++) {
    		if (isGreaterOrEqual(array.get(i), array.get(maxIndex))) {
    			maxIndex = i;
    		}
    	}
    	return maxIndex;
    }
    public static boolean isGreaterOrEqual(String a, String b) {
    	boolean retValue = true;
    	String ab = a + b;
    	String ba = b + a;
    	if (Integer.valueOf(ba) >= Integer.valueOf(ab)) {
    		retValue = false;
    	}
    	return retValue;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

