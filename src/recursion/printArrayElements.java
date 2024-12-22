/**
 * Created by Ritabrata, 22/12/2024
 *
 * printArrayElements.java -> Print all elements in an array in recursive way
 */

package recursion;

import java.util.Scanner;

public class printArrayElements {
    public static void displayArr(int[] a, int ind) {
        if (ind == a.length) {
            return;
        }
        System.out.println(a[ind]);
        displayArr(a, ind + 1);
    }

    public static void displayArrReverse(int[] a, int idx) {
        if (idx == -1) {
            return;
        }
        System.out.println(a[idx]);
        displayArrReverse(a, idx - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        displayArr(a, 0);
        System.out.println("======================");
        displayArrReverse(a, a.length - 1);
        sc.close();
    }
}
