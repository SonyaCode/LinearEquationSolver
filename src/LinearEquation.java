public class LinearEquation {
    // instance variables
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    // constructor
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    /* calculates and returns the distance between (x1, y1) and (x2, y2)
    rounded to the nearest hundredth */
    public double distance() {
        double xDistance = Math.pow(x2 - x1, 2);
        double yDistance = Math.pow(y2 - y1, 2);
        double distance = Math.sqrt(xDistance + yDistance);
        return roundedToHundredth(distance);
    }


    /* Calculates and returns the slope of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double slope() {
        double numerator = y2 - y1;
        double denominator = x2 - x1;
        return roundedToHundredth(numerator / denominator);
    }


    /* Calculates and returns the y-intercept of the line between (x1, y1) and
   (x2, y2), rounded to the nearest hundredth */
    public double yIntercept() {
        double b = y1 - (slope() * x1);
        return roundedToHundredth(b);
    }


    public String equation() {
        // converting the slope to "printable" slope
        int slopeNumerator = y2 - y1;
        int slopeDenominator = x2 - x1;
        String m = "";
        if (slopeNumerator % slopeDenominator == 0) {
            m = (slopeNumerator / slopeDenominator) + "";
            // if it is horizontal line, just return y = y-int
            if (m.equals("0")) {
                return "y = " + (int) yIntercept();
            } else if (m.equals("1")) {
                m = "";
            } else if (m.equals("-1")) {
                m = "-";
            }
        } else {
            if (slopeNumerator < 0 && slopeDenominator < 0) {
                m = Math.abs(slopeNumerator) + "/" + Math.abs(slopeDenominator);
            } else if (slopeDenominator < 0) {
                String convertToStrNumerator = slopeNumerator + "";
                String convertToStrDenominator = slopeDenominator + "";
                convertToStrDenominator = convertToStrDenominator.substring(1); // take the negative sign away from the denominator
                convertToStrNumerator = "-" + convertToStrNumerator; // put the negative sign next to the numerator
                m = convertToStrNumerator + "/" + convertToStrDenominator;
            } else {
                m = slopeNumerator + "/" + slopeDenominator;
            }
        }
        if (yIntercept() > 0) {
            return "y = " + m + "x + " + yIntercept(); // plus sign if the y-int is positive
        } else if (yIntercept() < 0) {
            return "y = " + m + "x - " + Math.abs(yIntercept()); // minus sign if the y-int is negative
        } else {
            return "y = " + m + "x"; // do not display the y-int if there is no y-int
        }

    }


    /* Returns a String of the coordinate point on the line that has the given x value, with
       both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
    // return with (x, y)
    public String coordinateForX(double xValue) {
        double yCoordinate = slope() * xValue + yIntercept();
        yCoordinate = roundedToHundredth(yCoordinate);
        return "(" + xValue + ", " + yCoordinate + ")";
    }


    /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
        to the nearest hundredth */
    public double roundedToHundredth(double toRound) {
        return (double) Math.round(toRound * 100) / 100;
    }


    // print info about this line
    public String lineInfo() {
        String twoPoints = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")";
        String equationInfo = "The equation of the line between these points is: " + equation();
        String slopeInfo = "The slope of this line is: " + slope();
        String yInterceptInfo = "The y-intercept of the line is: " + yIntercept();
        String distanceInfo = "The distance between the points is: " + distance();
        return twoPoints + "\n" + equationInfo + "\n" + slopeInfo + "\n" + yInterceptInfo + "\n" + distanceInfo;
    }

}