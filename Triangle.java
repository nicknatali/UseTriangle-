

/**
 * Created by NickNatali on 9/12/16.
 */
public class Triangle {

    private double sideA;
    private double sideB;
    private double sideC;



    public Triangle(double a, double b, double c) {
        sideA = a;
        sideB = b;
        sideC = c;
    }

    public boolean isEquilateral() {
        return (sideA == sideB) && (sideA == sideC);
    }

    public boolean isIsosceles() {
        return(sideA == sideB) || (sideB == sideC) || (sideA == sideB);
    }

    public boolean isScalene() {
        return(sideA != sideB) && (sideB != sideC) && (sideA != sideC);
    }

    public boolean isTriangle() {
        return (sideA > 0) && (sideB > 0) && (sideC > 0) && (sideA + sideB > sideC) && (sideB + sideC > sideA) && (sideA + sideC > sideB);
    }


}
