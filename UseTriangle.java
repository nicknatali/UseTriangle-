/**
 * Created by NickNatali on 9/28/16.
 */

import java.io.*;
import java.util.Scanner;




public class UseTriangle {
    //This function determines whether the user continues the program or not
    public static String continueProgram(String continueTriangle, Scanner input)
    {
        boolean error = true;
        do {
            //Evaluates the user's choice
            if (continueTriangle.equals("YES")) {
                error = false;
                //Prompt user
                System.out.println("Let's make a triangle! \n");

            } else if (continueTriangle.equals("NO")) {
                error = false;
            System.out.println("Thank you for our using our program."); //Typo in the spec
        }

            //This is being displayed twice, and I'm not sure why. Any ideas?
              if (error == true) {

                    System.out.println("Not quite... Enter \'YES\' to continue or \'NO\' to exit");
                    continueTriangle = input.nextLine(); //allows user to re-enter
               }

            }
            while (error == true) ;
            return continueTriangle;
        }


    public static void main(String[] args) {

        //Variables
        String continueProcess = "";
        String typeOfTriangle = "";
        double sidesOfTriangle [] = {0, 0, 0};
        Scanner input = new Scanner(System.in);

        //Prompt user
        System.out.println("Let's make a triangle! \n");
        do {

            boolean validInput = false;
            boolean notATriangle = true;

            do {

                System.out.println("Please enter 3 integers or decimals:");
                for (int i = 0; i < 3; i++)  //Loops through to put the inputs into an array.
                {
                    while (!validInput)      //While validInput is true, check if it's false.
                    {
                        try {
                            sidesOfTriangle[i] = Double.parseDouble(input.next()); //Basically converts their input into positive

                        } catch (NumberFormatException nfe) //Built in Java to check for characters
                        {
                            System.out.println("Enter a number not a character you silly goose.");
                        }
                        finally
                        {
                            //If any input is not positive
                            if (sidesOfTriangle[i] <= 0) {
                                System.out.println("Enter a positive number!");
                                continue; //Continue essentially makes them re-enter the input in this case.
                            }
                            else {
                                validInput = true;
                            }
                        }
                    } //While loop ends.
                    validInput = false; //Allows users to enter another input.
                    if (i == 2) //Array is full! (For loop is done).
                    {
                        notATriangle = Triangle.notATriangle(sidesOfTriangle[i - 2], sidesOfTriangle[i - 1], sidesOfTriangle[i]);

                        //Check to see if their inputs can make a proper triangle.
                        if (notATriangle  == true) {
                            System.out.println("\n");
                            System.out.println("Your input does not create a correct triangle.");
                        }
                    }
                }
            }
            while (notATriangle  == true);

            //Create a triangle object to use the contents in the Triangle Class
            Triangle triangleObject = new Triangle(sidesOfTriangle[0], sidesOfTriangle[1], sidesOfTriangle[2]);

            //Check to see what type of triangle it is.
            if (triangleObject.isEquilateral()) {
                typeOfTriangle = "equilateral";
            }else if (triangleObject.isIsosceles()) {
                typeOfTriangle = "isosceles";
            } else{
                typeOfTriangle = "scalene"; }

            System.out.println("This is a(n) " + typeOfTriangle + " triangle. Thank you for our using our program. \n"); //typo in the spec
            System.out.println("Would you like to create another triangle?");
            System.out.println("Type in \'YES\' to continue or \'NO\' to quit.");
            continueProcess = continueProgram(continueProcess, input); //Runs the function and waits for entry to determine whether to continue
        }
        while (continueProcess.equals("YES")); //Keep going if they entered YES


    }
}























/*PLEASE IGNORE THE COMMENTS BELOW - THESE WERE ALL MY FAILED ATTEMPTS - BUT I LIKE LOOKING AT THEM FOR REFERENCE */


/*import java.io.*;
import java.util.Scanner;

public class UseTriangle {

    //Checks the input that the user has entered
    public void checkInput() {

        double sidesOfTriangle[] = {0, 0, 0};   //Array to hold the sides of a triangle
        Scanner input = new Scanner(System.in); //So User can enter the numbers
        int decision;
        Scanner choice = new Scanner(System.in);
        decision = choice.nextInt();

        boolean validInput = false;         //Check if the input is valid
        boolean notATriangle = true;        //Check if it is or is not a triangle
        boolean start = true;

        while (start) {


            for (int i = 0; i < 3; i++)   // For loop to input sides into an array
            {
                while (!validInput) {
                    try {
                        sidesOfTriangle[i] = Double.parseDouble(input.next()); // Make their inputs positive
                    } catch (NumberFormatException nfe) //Error handling for characters
                    {
                        System.out.println("No characters allowed. Try again.");
                        continue;

                    } finally {
                        //If any of the sides are less than 0
                        if (sidesOfTriangle[i] <= 0) {
                            System.out.println("Error in entry. Enter a positive number.");

                            //redo entry if 0 or negative
                        } else {
                            validInput = true; //exit while loop
                        }

                    }

                    //Create an object of Type triangle to get acess to the Triangle class's content
                    Triangle triangleObject = new Triangle(sidesOfTriangle[0], sidesOfTriangle[1], sidesOfTriangle[2]);

                    if (i == 2) {


                        //If statements to specify what type of triangle it is.
                        if (triangleObject.isEquilateral()) {
                            System.out.println("This is a(n) equilateral triangle. Thank you for our using our program.");
                            notATriangle = false;

                        } else if (triangleObject.isIsosceles()) {
                            System.out.println("This is a(n) isosceles triangle.  Thank you for our using our program.");
                            notATriangle = false;
                        } else if (triangleObject.isScalene()) {
                            System.out.println("This is a(n) scalene triangle.  Thank you for our using our program.");
                            notATriangle = false;
                        } else if (triangleObject.notATriangle(sidesOfTriangle[i - 2], sidesOfTriangle[i - 1], sidesOfTriangle[1])) {
                            System.out.println("Not a triangle.");
                            notATriangle = true;
                        }

                    }
                    //end while validInput
                    validInput = true; //reset to continue to next double


                }
            }
            //Prompt user to play again
            System.out.println("Want to enter another triangle? Enter 1 for yes, Enter 2 for no.");

            //Switch Case for user to continue trying to enter 1 or 2 until they actually enter 1 or 2

            switch (decision) {
                case 1:
                    start = true;
                    break;
                case 2:
                    System.out.println("Thank you for our using our program.");
                    start = false;
                    break;
                default:
                    System.out.println("You did not enter 1 or 2. Try again. ");
                    start = false;

            }
        }
    }









    public static void main(String[] args) {

        System.out.println("Let's make a triangle!");
        System.out.println("Input three positive integers or decimals:"); //Prompt the user

            UseTriangle callFunctions = new UseTriangle();
            callFunctions.checkInput();


    }





}*/



/*
public class UseTriangle {




    public static void main(String args[]) {

        boolean start = true;
        double a = 0;
        double b = 0;
        double c = 0;

        while (start) {

            int x = 1;
           // boolean validInput = true;
           // double triangleSides[] = { 0, 0, 0};
            Scanner input = new Scanner(System.in);

            do {
                try {

                    System.out.println("Please enter a positive integer or decimal for the first side of the triangle: ");
                    Scanner sides = new Scanner(System.in);
                    a = sides.nextDouble();

                    //If the first side is not greater than zero, prompt them again
                    if (a <= 0) {
                        System.out.println("You were close, please enter a value greater than 0 for the first side. ");

                        //If the first side is greater than zero, continue to the second side
                    } else {
                        System.out.println("Good Job. Please enter a positive integer or decimal for the second side of the triangle: ");
                        b = sides.nextDouble();


                        //If the second side is not greater than zero, prompt them again
                        if (b <= 0) {
                            System.out.println("You were close, please enter a value greater than 0 for the second side: ");
                            b = sides.nextDouble();

                            //If the second side was greater than zero, continue to the third side
                        } else {
                            System.out.println("Nice. Please enter a positive integer or decimal for the third side of the triangle:  ");
                            c = sides.nextDouble();

                            //If the third side is not greater than zero, prompt them again
                            if (c <= 0) {

                                System.out.println("You were close, please enter a value greater than 0 for the third side: ");

                                c = sides.nextDouble();
                            }

                        }
                    }
                    x = 2;

                } catch (Exception e) {
                    System.out.println("Hmmm... That's not a valid input. Let's try again");
                }

            } while (x == 1);

            //Create an object of type Triangle to get access to the Triangle class's content
            Triangle triangleObject = new Triangle(a, b, c);

            //If notATriangle is equal to false, that means it is a triangle
            if (triangleObject.notATriangle(a, b, c)) {
                //If statements to specify what type of triangle it is.
                if (triangleObject.isEquilateral()) {
                    System.out.println("This is a(n) equilateral triangle. Thank you for our using our program.");

                } else if (triangleObject.isIsosceles()) {
                    System.out.println("This is a(n) isosceles triangle.  Thank you for our using our program.");
                } else if (triangleObject.isScalene()) {
                    System.out.println("This is a(n) scalene triangle.  Thank you for our using our program.");
                } else {

                    System.out.println("Not a triangle.");
                }

                //Prompt user to play again
                System.out.println("Want to enter another triangle? Enter 1 for yes, Enter 2 for no.");

                //Switch Case for user to continue trying to enter 1 or 2 until they actually enter 1 or 2

                int decision;
                Scanner choice = new Scanner(System.in);
                decision = choice.nextInt();


                switch (decision) {
                    case 1:
                        start = true;
                        break;
                    case 2:
                        start = false;
                        System.out.println("Thank you for our using our program.");
                        break;
                    default:
                        System.out.println("You did not enter 1 or 2. Thank you for our using our program.");
                        start = false;
                }

            }


        }
    }
}
*/









