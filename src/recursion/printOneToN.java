/**
 * printOneToN.java
 * <p>
 * This file contains the recursive code to print from 1 to N
 */

package recursion;

import java.util.Scanner;

public class printOneToN {
    public static void printNums(int n) {
        if (n == 0) {
            return;
        }
        printNums(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printNums(n);
        sc.close();
    }
}
