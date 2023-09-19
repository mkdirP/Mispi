package data;

public class Validator {
    public static boolean validateValues(Entry entry) {
        double x = entry.getX();
        double y = entry.getY();
        double r = entry.getR();
        return (x >= -5 && x <= 5) && (y >= -5 && y <= 5) && (r >= 1 && r <= 3);
    }

    public static boolean validateRange(Double X, Double Y, Double R){
        if ((X == null) || (Y == null) || (R == null)) throw new NullPointerException();
        if( (X >= 0 && X < R) && (Y >= 0 && Y <= R) ){
            return true;
        } else if( (X >= -R/2 && X <= 0) && (Y >= 0 && Y <= (X + R/2) ) ){
            return true;
        } else return (X >= 0) && (Y <= 0) && (X*X + Y*Y <= (R/2) * (R/2));
    }
}
