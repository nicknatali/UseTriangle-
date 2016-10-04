/**
 * Created by NickNatali on 9/28/16.
 */

public class Triangle {

    private double sideA;
    private double sideB;
    private double sideC;



    public Triangle(double a, double b, double c) {
        if(a > 0 && b > 0 && c > 0) {
            this.sideA = a;
            this.sideB = b;
            this.sideC = c;
        }
    }

    public static boolean notATriangle(double a, double b, double c)
    {
        //This is notATriangle when these expressions are NOT true.
        return !((c + a > b) && (b + a > c) && (b + c > a));
    }

    public boolean isEquilateral() {
        //The triangle is an equilateral when these statements ARE true.
        return (sideA == sideB) && (sideA == sideC);
    }

    public boolean isIsosceles() {
        //The triangle is an isosceles when these statements ARE true.
        return(sideA == sideB) || (sideB == sideC) || (sideA == sideC);
    }

    public boolean isScalene() {
        //The triangle is an scalene when these statements ARE true.
        return(sideA != sideB) && (sideB != sideC) && (sideA != sideC);
    }





}