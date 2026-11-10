package Inputs;

import java.util.Scanner;

public class Inputs {
    public static void main(String[] args) {
        System.out.print("Enter your role number:");

        Scanner input = new Scanner(System.in);//-> takes the input
        int rollNo = input.nextInt();//->input is assigned to rollNo

        System.out.println("Your roll number is: " + rollNo);

        

        // Type conversion: smaller datatype into larger datatype
        //The Widening Order:byte ->short ->int ->long ->float ->double
        System.out.print("Enter your english marks:");
        int marks = input.nextInt();
        float actualMarks = marks;//Implicit conversion-> behind the scene
        System.out.println("Your actual marks in english are: " + actualMarks);

        // Type casting:
        System.out.println("Your entered english marks are: " + (int)(actualMarks));

        input.close();
    }
}
