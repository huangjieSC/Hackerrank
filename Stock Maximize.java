import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().split(" ");
            int[] size = new int[s.length];
            
            for (int i = 0; i < size.length; i++) {
                size[i] = Integer.parseInt(s[i]);
            }
            
            String[] s2 = sc.nextLine().split(" ");
            if (s2.length != size[0]) continue;
            
            int[] val = new int[s2.length];
            
            for (int i = 0; i < val.length; i++) {
                val[i] = Integer.parseInt(s2[i]);
            }
            
            long profit = 0;
            int currMax = Integer.MIN_VALUE;
                    
            for (int j = val.length - 1; j >= 0; j--) {
                if (currMax < val[j]) {
                    currMax = val[j];
                }
                profit += (currMax - val[j]);
            }
            System.out.println(profit);
        }
        sc.close();
    }
}
