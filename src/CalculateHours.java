import java.text.DecimalFormat;
import java.util.StringTokenizer;

/**
 * Created by Ron Rith on 9/3/2018.
 */
public class CalculateHours {
    static String TMORNING = "T-Morning";
    static String TAFTERNOON = "T-Afternoon";

    public static void main(String args[]){
        String login = "09:18";
        String logout = "11:55";
        /*Double logingConvert = getHoursFormat("7:44");
        if (logingConvert > 2) {
            System.out.println("logingConvert>2");
        }
        System.out.println("Login Convert: " + logingConvert);*/

        String hourWorking = getHoursWorking(TAFTERNOON,login,logout);
    }

    //getHours from 7:77 to 7.77
    public static Double getHoursFormat(String hmm){
        if (hmm != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(hmm, ":");
            String hour = "";
            String mm = "";
            String number = "";
            while (stringTokenizer.hasMoreElements()) {
                hour = stringTokenizer.nextToken();
                mm = stringTokenizer.nextToken();
            }
            number = hour + "." + mm;
            System.out.println("Number: " + number);
            return Double.valueOf(number);
        }
        return null;
    }

    public static String getHoursFormatResult(Double hmm){
        String getPara = String.valueOf(hmm);
        StringTokenizer stringTokenizer = new StringTokenizer(getPara, ".");
        String hour = "";
        String mm = "";
        String number = "";
        while (stringTokenizer.hasMoreElements()) {
            hour = stringTokenizer.nextToken();
            mm = stringTokenizer.nextToken();
        }
        System.out.println("----------");
        System.out.println("MM: " + mm);
        number = hour + ":" + mm;
        return String.valueOf(number);
    }

    // get decimal like 77.77
    public static Double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    // convert value from hour.mm to hour:mm
    public static String getExactlyHours(String hours) {
        StringTokenizer stringTokenizer = new StringTokenizer(hours, ".");
        String h = "";
        String mm = "";
        Integer hd = null;
        Integer mmd = null;

        while (stringTokenizer.hasMoreElements()) {
            h = stringTokenizer.nextToken();
            mm = stringTokenizer.nextToken();
        }
        hd = Integer.valueOf(h);
        mmd = Integer.valueOf(mm);
        if (mmd >= 60) {
            mmd = mmd - 60;
            hd = hd + 1;
        }
        return hd + ":" + mmd;
    }

    // get hour afternoon by add 12 hour more
    public static String getHoursAfternoon(String timeTable,String hm){
        StringTokenizer stringTokenizer = new StringTokenizer(hm, ":");
        String h = "";
        String m = "";
        Integer hh = null;
        Integer mm = null;

        while (stringTokenizer.hasMoreElements()) {
            h = stringTokenizer.nextToken();
            m = stringTokenizer.nextToken();
        }
        hh = Integer.valueOf(h);
        mm = Integer.valueOf(m);

        if (timeTable.equals(TAFTERNOON)) {
            if (mm < 12) {
                mm = mm + 12;
            }
        }

        return hh + ":" + mm;
    }

    public static String getHoursWorking(String timeTable,String login,String logout){
        Double loginC = getHoursFormat(getHoursAfternoon(timeTable,login));
        Double logoutC = getHoursFormat(getHoursAfternoon(timeTable,logout));
        Double result = logoutC - loginC;
        System.out.println("Result: "+result);
        // Equal and bigger than 60 mn must sub
        System.out.println("Round: " + round(result, 2));
        Double r = round(result, 2);
        System.out.println("R: "+r);
        String h = getExactlyHours(r.toString());
        //String h = getHoursFormatResult(r);
        System.out.println("Hour working: "+h);
        return h;
    }

}
