/*
Created by Ritabrata, 2024
 */

package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapImplementation {
    public static void printHashMap() {
        // Creating a map structure using hashmap
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Orange");
        hashMap.put(4, "Apple");
        hashMap.put(2, "Jackfruit");
        System.out.println(hashMap);
        System.out.println("========================== ");
    }

    public static void printHashMapUsingKeyValueAttribute() {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Orange");
        hashMap.put(4, "Apple");
        hashMap.put(2, "Jackfruit");
        for (Map.Entry<Integer, String> mapItr : hashMap.entrySet()) {
            System.out.println(mapItr.getKey() + " = " + mapItr.getValue());
        }
        System.out.println("========================== ");
    }

    // LinkedHashMap will print the data in the order in which data was inserted in the map
    public static void printLinkedHashMap() {
        Map<Integer, String> hashMap = new LinkedHashMap<>();
        hashMap.put(1, "Blue");
        hashMap.put(3, "Red");
        hashMap.put(2, "Yellow");
        hashMap.put(8, "Black");
        hashMap.put(5, "Green");
        for (Map.Entry<Integer, String> mapItr : hashMap.entrySet()) {
            System.out.println(mapItr.getKey() + " = " + mapItr.getValue());
        }
        System.out.println("========================== ");
    }

    // TreeMap will sort the map contents based on the Key and store it.
    public static void printTreeMap() {
        Map<Integer, String> hashMap = new TreeMap<>();
        hashMap.put(5, "Yellow");
        hashMap.put(12, "Black");
        hashMap.put(3, "Orange");
        hashMap.put(2, "Red");
        hashMap.put(1, "Green");
        hashMap.put(8, "White");
        for (Map.Entry<Integer, String> mapItr : hashMap.entrySet()) {
            System.out.println(mapItr.getKey() + " = " + mapItr.getValue());
        }
        System.out.println("========================== ");
    }

    // Use of treeMap can be demonstrated with an implementation
    // Problem : Count the occurrence/frequency of each character in a given string
    public static void findOccurrenceofCharsInString(String s) {
        char[] c = s.toCharArray();
        Map<Character, Integer> map = new TreeMap<>();
        for (char c1 : c) {
            if (!map.containsKey(c1)) {
                map.put(c1, 1);
            } else {
                map.put(c1, map.getOrDefault(c1, 1) + 1);
            }
        }
        // Here key is the Character, so the output will be in sorted order of characters
        System.out.println(map);
        System.out.println("========================== ");
    }

    // Printing all the values in a map
    public static void printMapValues() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Maths", 95);
        map.put("Physics", 83);
        map.put("Chemistry", 95);
        map.put("English", 80);
        map.put("Geography", 74);
        map.put("History", 88);
        map.put("Bengali", 81);
        System.out.print("Map values : ");
        for (int p : map.values()) {
            System.out.print(p + " ");
        }
        System.out.println();
        System.out.println("========================== ");
    }

    // Printing all the keys in a map
    public static void printMapKeys() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Maths", 95);
        map.put("Physics", 83);
        map.put("Chemistry", 95);
        map.put("English", 80);
        map.put("Geography", 74);
        map.put("History", 88);
        map.put("Bengali", 81);
        System.out.print("Map values : ");
        for (String p : map.keySet()) {
            System.out.print(p + " ");
        }
        System.out.println();
        System.out.println("========================== ");
    }

    public static void main(String[] args) {
        printHashMap();
        printHashMapUsingKeyValueAttribute();
        printLinkedHashMap();
        printTreeMap();
        findOccurrenceofCharsInString("madam");
        printMapValues();
        printMapKeys();
    }

}
