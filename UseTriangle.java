/**
 * Created by NickNatali on 9/13/16.
 */

import java.util.Scanner;

public class UseTriangle {


    public static void main(String args[]) {
        boolean another = true;

        while (another) {
            double a, b, c;
            System.out.println("Please enter the first side of the triangle: ");
            Scanner sides = new Scanner(System.in);
            a = sides.nextDouble();
            System.out.println("Nice, how 'bout side two?:");
            b = sides.nextDouble();
            System.out.println("Good job! What about the third side?: ");
            c = sides.nextDouble();

            Triangle triangleObject = new Triangle(a, b, c);


            if (triangleObject.isTriangle()) {

                if (triangleObject.isEquilateral()) {
                    System.out.println("Triangle is an equilateral.");

                } else if (triangleObject.isIsosceles()) {
                    System.out.println("Triangle is an Isosceles.");
                } else if (triangleObject.isScalene()) {
                    System.out.println("Triangle is a Scalene");
                }


            } else {
                System.out.println("Not a triangle, try again buddy.");

            }

            System.out.println("Want to enter another triangle? Enter 1 for yes, Enter 2 for no.");

            int decision;
            Scanner choice = new Scanner(System.in);
            decision = choice.nextInt();

            switch (decision) {
                case 1:
                    another = true;
                    break;
                case 2:
                    another = false;
                    System.out.println("It's been fun, see you next time.");
                    break;
                default:
                    System.out.println("You did not enter 1 or 2. You are done.");
                    another = false;
            }


        }


    }
}
