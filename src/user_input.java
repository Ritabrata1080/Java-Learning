import java.util.Scanner;

public class user_input1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Initializing scanner object to take inputs
        // Asking user to enter the name. print() will hold the cursor on same line
        System.out.print("Enter your name : ");

        // Taking the string input. nextLine() will take the whole input
        // even if space is there in between till user enters nextLine
        String s = sc.nextLine();
        System.out.println("Your name is : " + s);

        // Taking integer inputs
        System.out.print("Enter your age : ");
        int age = sc.nextInt();
        System.out.println("Your age is : " + age);
    }
}
