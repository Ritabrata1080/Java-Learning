/*
Created by Ritabrata, 15/08/2024
 */

package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListImplementation {
    // Return the size of the list passed as parameter
    public static int arrayListSize(List<?> list){
        return list.size();
    }

    public static void printListContentUsingForLoop(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    // This method will declare and populate an arraylist and then print the content of the list.
    public static void printArrayList() {
        List<String> list = new ArrayList<>();
        list.add("Code");
        list.add("Program");
        list.add("Compile");
        list.add("Deployment");
        int length = arrayListSize(list);
        System.out.println(arrayListSize(list));

        // Printing list content using normal for loop
        printListContentUsingForLoop(list);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printArrayList();

        sc.close();
    }
}
