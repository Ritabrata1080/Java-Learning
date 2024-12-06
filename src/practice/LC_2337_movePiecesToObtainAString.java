/**
 * Created by Ritabrata
 */

package practice;

import java.util.Scanner;

/**
 * ########### Problem Statement #############
 * You are given two strings start and target, both of length n. Each string consists only of the characters 'L', 'R', and '_' where:
 * <p>
 * The characters 'L' and 'R' represent pieces, where a piece 'L' can move to the left only if there is a blank space
 * directly to its left,
 * and a piece 'R' can move to the right only if there is a blank space directly to its right.
 * The character '_' represents a blank space that can be occupied by any of the 'L' or 'R' pieces.
 * Return true if it is possible to obtain the string target by moving the pieces of the string start any number of times.
 * Otherwise, return false.
 */
public class LC_2337_movePiecesToObtainAString {
    public static boolean canChange(String s, String t) {
        int i = 0;
        int j = 0;
        int sLen = s.length();
        int tLen = t.length();
        while (i < sLen || j < tLen) {
            while (i < sLen && s.charAt(i) == '_') {
                i++;
            }
            while (j < tLen && t.charAt(j) == '_') {
                j++;
            }
            if (i == sLen && j == tLen) {
                return true;
            }
            if (i == sLen || j == tLen || s.charAt(i) != t.charAt(j)) {
                return false;
            }
            if (s.charAt(i) == 'L' && i < j) {
                    return false;
                }

            if (s.charAt(i) == 'R' && i > j) {
                    return false;
                }

            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        boolean result = canChange(s, t);
        System.out.println(result);
        sc.close();
    }
}
