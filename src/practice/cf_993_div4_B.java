package practice;

import java.util.Scanner;
import java.util.Stack;

public class cf_993_div4_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t --> 0){
            String s = sc.next();
            Stack<Character> st = new Stack<>();
            char[] c = s.toCharArray();
            for(char c1 : c){
                st.push(c1);
            }
            StringBuilder sb = new StringBuilder();
            while(!st.isEmpty()){
                char ch = st.pop();
                if(ch == 'w'){
                    sb.append(ch);
                }
                else if(ch == 'p'){
                    sb.append('q');
                }
                else {
                    sb.append('p');
                }
            }
            System.out.println(sb.toString());
        }
    }
}
