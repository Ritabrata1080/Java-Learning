/**
 * Created by Ritabrata, 22/12/2024
 * <p>
 * printIncreasingDecreasing.java -> Print all elements in an array in increasing and decreasing order in recursive way
 */

package recursion;

import java.util.Scanner;

public class printIncreasingDecreasing {
    public static void PDI(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        PDI(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PDI(n);
        sc.close();
    }
}
