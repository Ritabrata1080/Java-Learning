package practice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class codeton_round9_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t --> 0){
            String s = sc.next();
            boolean flag = false;
            for(int i = 0;i<s.length() - 1;i++){
                if(s.charAt(i) == s.charAt(i+1)){
                    StringBuilder sb = new StringBuilder();
                    sb.append(s.charAt(i)).append(s.charAt(i+1));
                    System.out.println(sb.toString());
                    flag = true;
                    break;
                }
            }
            if(!flag){
                for(int i = 0;i<s.length() - 2;i++){
                    Set<Character> set = new HashSet<>();
                    set.add(s.charAt(i));
                    set.add(s.charAt(i+1));
                    set.add(s.charAt(i+2));
                    if(set.size() == 3) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(s.charAt(i)).append(s.charAt(i+1)).append(s.charAt(i+2));
                        System.out.println(sb.toString());
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag){
                System.out.println(-1);
            }
        }
    }
}
