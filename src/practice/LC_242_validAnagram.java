/**
 * Created by Ritabrata
 */

/**
 *
 * <p>
 * ############ Problem description ############
 * <p>
 * Given two strings s and t, return true if t is an
 * anagram of s, and false otherwise.
 */

package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LC_242_validAnagram {

    // Approach 1 : Use HashMap to compare character and it's count
    public static boolean isAnagram_approach1(String s, String t) {
        // Take a Map to keep a count of number of characters present in the string s.
        // Then we will compare each character of string t with the map and reduce it's count based on the match.
        // Return the size of the map. If it's zero, then it's an anagram.
        Map<Character, Integer> map = new HashMap<>();

        // Base condition
        if (s.length() != t.length()) {
            return false;
        }
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            }
            if (map.containsKey(c) && map.get(c) == 0) {
                map.remove(c);
            }
        }
        return map.size() == 0;
    }

    // Approach 2 : Use sorting
    public static boolean isAnagram_approach2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            if (c1[i++] != c2[j++]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        boolean result = isAnagram_approach1(s, t);
        System.out.println(result);
    }
}
