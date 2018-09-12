/**
 * Created by DELL on 9/3/2018.
 */
public class MainTest {
    public static void main(String args[]){
        Double r = round(200.34563433344, 2); // returns 200.35
        System.out.println(r);
    }
    public static Double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
