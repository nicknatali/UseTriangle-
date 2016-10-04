/**
 * Created by NickNatali on 9/28/16.
 */

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UseTriangle {


    public static void main(String[] args) {
        System.out.println("Hello, let's make a triangle.");
        Scanner input = new Scanner(System.in);
        String continueTriangle = "";
        do {
            double sidesOfTriangle[] = getInput(input);   //Array to hold the sides of a triangle
            boolean notATriangle = Triangle.notATriangle(sidesOfTriangle[0], sidesOfTriangle[1], sidesOfTriangle[2]);


            if (notATriangle) {

                System.out.println("Not a Triangle.");

            } else {
                Triangle triangleObject = new Triangle(sidesOfTriangle[0], sidesOfTriangle[1], sidesOfTriangle[2]);
                String type = checkTriangle(triangleObject);
                System.out.println("Your triangle is of type: " + type);

            }
            System.out.println("Would you like to make another triangle? ");
            String garbage = input.nextLine();
            System.out.println("Please enter YES to continue or anything else to quit.");

            continueTriangle = input.nextLine().toUpperCase();
        }while(continueTriangle.equals("YES"));

            System.out.println("Thank you for using our program");
    }


    //Get and Check the input that the user has entered
    public static double[] getInput(Scanner input) {
        //Array to hold the sides of a triangle
        double sidesOfTriangle[] = {0, 0, 0};
        double inputNumber;
        //So User can enter the numbers
        boolean validInput = false;

        for (int i = 0; i < 3; i++)   // For loop to input sides into an array
        {

            while (!validInput) {
                System.out.println("Please enter a positive integer or decimal: ");
                try {
                    inputNumber = Double.parseDouble(input.next());
                    sidesOfTriangle[i] = inputNumber; // Make their inputs positive

                } catch (NumberFormatException ime) //Error handling for characters
                {

                    System.out.println("No characters allowed. Try again.");


                } finally {
                    //If any of the sides are less than 0
                    if (sidesOfTriangle[i] <= 0) {
                        System.out.println("Error in entry. Enter a positive number.");

                    } else {
                        validInput = true;
                    }

                }
            }
            validInput = false;
        }
        return sidesOfTriangle;
    }


    public static String checkTriangle(Triangle t) {
        String answer;

        if (t.isEquilateral() == true) {
            answer = "equilateral";
        } else if (t.isIsosceles() == true) {
            answer = "isosceles";
        } else {
            answer = "scalene";
        }
        return answer;
    }


}