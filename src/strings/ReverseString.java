/*
 Developed by Ritabrata, 05/08/2024
 */

package strings;

import java.util.Scanner;
import java.util.Stack;

public class ReverseString {

    // Reversing a string using stack
    public static String reverseStringWithStack(String s) {
        if (s.length() == 1) {
            return s;
        } else {
            // Stack works in LIFO or FILO concept.
            // So, breaking the string into character array and inserting in a stack
            // The stack will store the string in reverse order.
            // Now we will pop out all characters out of the stack and print the string
            Stack<Character> stack = new Stack<>();
            char[] c = s.toCharArray();
            for (char c1 : c) {
                stack.push(c1);
            }

            //It's always advisable to use stringbuilder in place of string pool.
            // StringBuilder is mutable and creates a space on the heap memory and not in pool of strings
            // This saves the JVM memory and reduces garbage collection time.
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.toString();
        }
    }

    // Reversing a string just by using a character array
    public static String reverseStringWithAnArray(String s) {
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = c.length - 1; i >= 0; i--) {
            sb.append(c[i]);
        }
        return sb.toString();
    }

    // Reversing a string using recursion
    public static void reverseStringUsingRecursion(String s) {
        if (s == null || s.length() <= 1) {
            System.out.print(s);
        } else {
            System.out.print(s.charAt(s.length() - 1));
            reverseStringUsingRecursion(s.substring(0, s.length() - 1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //System.out.println(reverseStringWithStack(str));
        //System.out.println(reverseStringWithAnArray(str));
        reverseStringUsingRecursion(str);
        sc.close();
    }
}
