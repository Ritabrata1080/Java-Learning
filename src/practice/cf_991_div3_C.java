package practice;

import java.util.Scanner;

public class cf_991_div3_C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while(t --> 0){
            String s = sc.next();
            char[] c = s.toCharArray();
            int sum = 0, countTwo = 0, countThree = 0;
            boolean flag = false;
            for(char c1 : c){
                sum += c1 - '0';
                if(c1 - '0' == 2){
                    countTwo++;
                }
                else if(c1 - '0' == 3){
                    countThree++;
                }
            }
            for(int i = 0;i<=Math.min(100, countTwo);i++) {
                for (int j = 0; j <= Math.min(100, countThree); j++) {
                    if ((sum + i * 2 + j * 6) % 9 == 0) {
                        flag = true;
                        break;
                    }
                }
            }
            if(flag){
                System.out.println("yes");
            }
            else{
                System.out.println("No");
            }
        }
    }
}
