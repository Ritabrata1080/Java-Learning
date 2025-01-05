package practice;

import java.util.Scanner;

public class cf_993_div4_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t --> 0){
            int n = sc.nextInt();
            int i = 1, j = n - 1;
            int count = 0;
            while(i<=j){
                if(i != j && i + j == n){
                    count+=2;
                    i++;
                    j--;
                }
                if(i == j && i + j == n) {
                    count++;
                    i++;
                    j--;
                }
                else if(i == j && i + j != n){
                    i++;
                    j--;
                }
            }
            System.out.println(count);
        }
    }
}
