package practice;

import java.util.Scanner;

public class cf_968_div2_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t --> 0){
            int n = sc.nextInt();
            String s = sc.next();
            if(s.charAt(0) == s.charAt(n - 1)){
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
            }
        }
    }
}
