import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Ron Rith on 9/4/2018.
 */

public class BaseFormatDate {
    public static String PATTERN = "E MMM dd HH:mm:ss Z yyyy";
    public static String PATTERN_DATE = "dd-MMM-yyyy";
    public static String PATTERN_DATE2 = "dd/MM/yyyy";
    public static String PATTERN_DATE3 = "yyyy-MM-dd";
    
    public static String getDateFormatToSQL(Date date) {
        if (date != null) {
            //Format To 18-Jun-2018
            String dateFormat = new SimpleDateFormat(PATTERN_DATE).format(date);
            return dateFormat;
        }
        return null;
    }

    //Format To 18/12/2018
    public static String getDateFormatToSQL2(Date date) {
        if (date != null) {
            String dateFormat = new SimpleDateFormat(PATTERN_DATE2).format(date);
            return dateFormat;
        }
        return null;
    }
    //Format To 2018-12-01
    public static String getDateFormatToSQL3(Date date) {
        if (date != null) {
            String dateFormat = new SimpleDateFormat(PATTERN_DATE3).format(date);
            return dateFormat;
        }
        return null;
    }
    public static Date getDateValue(String dateString) {
        //Get format from "Mon Jun 18 00:00:00 IST 2012";
        if (dateString != null) {
            DateFormat formatter = new SimpleDateFormat(PATTERN);
            Date date = null;
            try {
                date = (Date) formatter.parse(dateString);
                return date;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String getDateFromFormat(String dateString) {
        if (dateString != null) {
            Date date = null;
            date = getDateValue(dateString);
            String dfs = getDateFormatToSQL(date);
            return dfs;
        }
        return null;
    }

    public static String getDateFromFormat2(String dateString) {
        if (dateString != null) {
            Date date = null;
            date = getDateValue(dateString);
            String dfs = getDateFormatToSQL2(date);
            return dfs;
        }
        return null;
    }
    public static String getDateFromFormat3(String dateString) {
        if (dateString != null) {
            Date date = null;
            date = getDateValue(dateString);
            String dfs = getDateFormatToSQL3(date);
            return dfs;
        }
        return null;
    }
    public static void main(String args[]){
        /*String dd = getDateFromFormat3("Mon Jun 18 00:00:00 IST 2012");
        System.out.println("date date: "+dd);*/
        Date date = null;
        date = getDateFormatRD3("18-10-2018");
        System.out.println(date);
    }
    // get date format return type date
    public static Date getDateFormatRD(String stringDate){
        // stringDate must be in this format 18-Jun-2018
        SimpleDateFormat formatter = new SimpleDateFormat(PATTERN_DATE);
        try {
            Date date = formatter.parse(stringDate);
            //System.out.println("formatter.format(date)" + formatter.format(date));
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Date getDateFormatRD2(String stringDate){
        DateFormat format = new SimpleDateFormat(PATTERN_DATE, Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(stringDate);
            System.out.println(date); // 18-Jun-2018
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    // get // 18-10-2018 return Sun Apr 09 00:00:00 ICT 24
    public static Date getDateFormatRD3(String stringDate){
        DateFormat format = new SimpleDateFormat(PATTERN_DATE3, Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(stringDate);
            System.out.println(date);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
