/*
 Developed by Ritabrata, 2024
 */

import java.util.Scanner;

public class User_Input {
    public static void main(String[] args) {
        // Creating object of scanner class to take inputs
        Scanner sc = new Scanner(System.in);
        // print() will keep the cursor on same line,
        // while println() will move the cursor to next line after printing the details
        System.out.print("Please enter your name : ");
        // Nextline() will take input from user till user hits enter to proceed to next line
        String s = sc.nextLine();
        System.out.println("Your name is : " + s);

        // Taking integer inputs and printing their sum
        System.out.print("Enter the first number : ");
        int a = sc.nextInt();
        System.out.print("Enter the second number : ");
        int b = sc.nextInt();
        int sum = a + b;
        System.out.println("Sum of the two numbers : "+ sum);

        sc.close();
    }
}
