/**
 * Created by Ritabrata, Leetcode Solutions
 */

package practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ################# Problem statement ###############
 * <p>
 * <p>
 * Given an array arr of integers, check if there exist two indices i and j such that :
 * <p>
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 */
public class LC_1346 {
    public static boolean existsThroughBinSearch(int ind, int x, int[] a) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == 2 * x && ind != mid) {
                return true;
            } else if (a[mid] > 2 * x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (existsThroughBinSearch(i, arr[i], arr)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        boolean result = checkIfExist(arr);
        System.out.println(result);
        sc.close();
    }
}
