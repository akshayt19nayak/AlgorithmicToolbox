package Week4;
import java.util.*;
import java.io.*;

public class MajorityElement {
    /*private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        //write your code here
    	return -1;
    }*/
	/*private static int getMajorityElement(int[] a, int original_length) {
        //write your code here
		System.out.println(Arrays.toString(a));
		int count = 1;
		ArrayList<Integer> notEqualTo = new ArrayList<Integer>(); 
		while (a.length > original_length/2) {
			for(int i=1; i<a.length; i++) {
				if (a[i] == a[0]){
					count += 1;
					if (count > original_length/2) {
						return a[0];
					}
				}
				else {
					notEqualTo.add(a[i]);
				}
			}
			return getMajorityElement(toPrimitive(notEqualTo), original_length);
		}
    	return -1;
    }
	private static int[] toPrimitive(ArrayList<Integer> objectArray){
		int length = objectArray.size();
		int[] primitiveArray = new int[length];
		for (int i=0; i<length; i++) {
			primitiveArray[i] = objectArray.get(i);
 		}
		return primitiveArray;
	}*/
	private static int getMajorityElement(int[] a, int left, int right) {
		a = mergeSort(a, left, right);
		int countMajority = 0;
		int majority = a[0];
		for(int i=0; i<a.length; i++) {
			if (a[i]==majority) {
				countMajority += 1;
			}
			else {
				majority = a[i];
				countMajority = 1;
			}
			
			if (countMajority > a.length/2) {
				return majority;
			}
		}
		return -1;
	}
	public static int[] mergeSort(int[] a, int left, int right) {
    	int n = right-left;
    	if (n < 1) {
    		int[] retvalue = {a[right]};
    		return retvalue;
    	}
    	int m = left + (n/2);
    	int[] b = mergeSort(a, left, m);
    	int[] c = mergeSort(a, m+1, right);
    	int[] merged = merge(b, c);
    	return merged;
    }
    public static int[] merge(int[] b, int[] c) {
    	int[] d = new int[b.length + c.length];
    	int i = 0;
    	int j = 0;
    	while ((i<b.length) && (j<c.length)) {
    		int b_first = b[i];
    		int c_first = c[j];
    		if (b_first<=c_first) {
    			d[i+j] = b[i];
    			i += 1;
    		}
    		else {
    			d[i+j] = c[j];
    			j += 1;
    			}
    	}
    	while (i<b.length) {
    		d[i+j] = b[i];
    		i += 1;
    	}
    	while (j<c.length) {
    		d[i+j] = c[j];
    		j += 1;
    	}
    	return d;
    }
	public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length -1) != -1) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

