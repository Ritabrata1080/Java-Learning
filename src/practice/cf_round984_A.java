/**
 * Created by Ritabrata, 17/11/2024
 */

package practice;

import java.util.*;

public class cf_round984_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            boolean flag = false;
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < n - 1; i++) {
                if (Math.abs(arr[i + 1] - arr[i]) == 5 || Math.abs(arr[i + 1] - arr[i]) == 7) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
