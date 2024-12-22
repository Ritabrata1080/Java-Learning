/**
 * Created by Ritabrata, 22/12/2024
 *
 * factorial.java -> Print factorial of a number in recursive way
 */

package recursion;

import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = printFactorial(n);
        System.out.println(res);
        sc.close();
    }

    private static int printFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative numbers doesn't qualify for factorial evaluation");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * printFactorial(n - 1);
    }
}
