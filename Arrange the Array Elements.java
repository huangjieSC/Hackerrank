import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int size = sc.nextInt(); 
            int[] result = new int[size];
            int[] A = new int[size];
            int AIndex = 0;
            
            int index = 0;
            int voidCount = 0;
            while (size > 0) {
                int val = sc.nextInt();
                if (val == -1) {
                    size--;
                    voidCount++;
                    continue;
                } else {
                    A[index] = val;
                }
                size--;
                index++;
                AIndex++;
            }

            int BSize = sc.nextInt();
            int[] B = new int[BSize];
            index = 0;
            while (BSize > 0) {
                B[index] = sc.nextInt();
                index++;
                BSize--;
            }
            
            index = A.length - 1;
            int BIndex = B.length - 1;
            AIndex--;

            
            while (AIndex >= 0 || BIndex >=0) {
                if (AIndex < 0) {
                    A[index] = B[BIndex];
                    BIndex--;
                    index--;
                    continue;
                }
                if (BIndex < 0) {
                    A[index] = A[AIndex];
                    AIndex--;
                    index--;
                    continue;
                }
                    
                if (A[AIndex] > B[BIndex]) {
                    A[index] = A[AIndex];
                    AIndex--;
                } else{
                    A[index] = B[BIndex];
                    BIndex--;
                }
                index--;
            }
            for (int i : A) {
                System.out.println(i);
            }
        }
    }
}
