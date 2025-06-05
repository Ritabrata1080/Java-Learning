/**
 * Created by Ritabrata
 */

package practice;

import java.util.*;
public class meesho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] a = new int[n];

        for(int i = 0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int[][] queries = new int[q][3];
        for(int i = 0;i<q;i++){
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
            queries[i][2] = sc.nextInt();
        }
        for(int[] it : queries) {
            int sum = 0;
            int type = it[0];
            if(type == 1) {
                for(int i = it[1] - 1;i<it[2];i++) {
                    if(a[i] % 2 == 0){
                        a[i] /= 2;
                    }
                    else if(a[i] % 3 == 0){
                        a[i] /= 3;
                    }
                    else {
                        if (a[i] == 1) {
                            a[i] /= 1;
                        }
                        for (int j = 5; j * j <= a[it[2]]; j += 6) { // Check factors of form 6k ± 1
                            if (a[i] % j == 0) {a[i] = a[i]/j;}
                            if (a[i] % (j + 2) == 0) {a[i] /= (j+2);}
                        }
                        a[i] /= a[i];
                    }
                }
            }
            else if(type == 2) {
                for(int i = it[1] - 1;i<it[2];i++){
                    sum += a[i];
                }
                System.out.println(sum);
            }
            else{
                a[it[1]] = it[2];
            }
        }

    }

}
