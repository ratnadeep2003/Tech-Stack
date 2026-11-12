package Functions;

import java.util.Scanner;

public class AddNumbers {

    // method definition: a and b are parameters
    static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int x = sc.nextInt();

        System.out.print("Enter second number: ");
        int y = sc.nextInt();

        int result = add(x, y); // x and y are arguments
        System.out.println("Sum: " + result);

        sc.close();
    }
}