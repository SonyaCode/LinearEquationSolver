import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome!");
        // ask user to enter 2 coordinate points
        System.out.print("Enter coordinate 1: ");
        String coordinate1 = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        String coordinate2 = scan.nextLine();
        System.out.println();

        // extract the integer from the string and convert it to int coordinate 1
        // remove the parentheses
        String extractInt1 = coordinate1.substring(1, coordinate1.length() - 1);
        int idxOfComma1 = extractInt1.indexOf(",");
        // convert x-coordinate to int
        int xCoordinate1 = Integer.parseInt(extractInt1.substring(0, idxOfComma1));
        int idxOfSpace1 = extractInt1.indexOf(" ");
        // convert y-coordinate to int
        int yCoordinate1 = Integer.parseInt(extractInt1.substring(idxOfSpace1 + 1));

        // coordinate 2
        String extractInt2 = coordinate2.substring(1, coordinate2.length() - 1);
        int idxOfComma2 = extractInt2.indexOf(",");
        int xCoordinate2 = Integer.parseInt(extractInt2.substring(0, idxOfComma2));
        int idxOfSpace2 = extractInt2.indexOf(" ");
        int yCoordinate2 = Integer.parseInt(extractInt2.substring(idxOfSpace2 + 1));

        // if the slope is vertical
        if (xCoordinate1 == xCoordinate2) {
            System.out.println("These points are on a vertical line: x = " + xCoordinate1);
        } else {
            // create an object with the coordinates
            LinearEquation linearEquation = new LinearEquation(xCoordinate1, yCoordinate1, xCoordinate2, yCoordinate2);

            System.out.println(linearEquation.lineInfo());
            System.out.println();

            // find the y for the x-coordinate entered
            System.out.print("Enter a value for x: ");
            double xValue = scan.nextDouble();
            System.out.println();
            System.out.println("The point on the line is " + linearEquation.coordinateForX(xValue));
        }
    }
}