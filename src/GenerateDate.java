import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ron Rith on 9/4/2018.
 */
public class GenerateDate {
    public static void main(String args[]){
        List<Date> dates = new ArrayList<>();

        String str_date ="01/09/2018";
        String end_date ="12/09/2018";

        dates = (List<Date>) get10Days(str_date,end_date);

    }

    public static List<Date> get10Days(String stDate,String enDate){
        List<Date> dates = new ArrayList<>();
        List<Date> tenDates = new ArrayList<>();
        DateFormat formatter ;

        formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date  startDate = null;
        try {
            startDate = (Date) formatter.parse(stDate);
            Date endDate = (Date) formatter.parse(enDate);
            long interval = 24 * 1000 * 60 * 60; // 1 hour in millis
            long endTime = endDate.getTime(); // create your endtime here, possibly using Calendar or Date
            long curTime = startDate.getTime();
            while (curTime <= endTime) {
                dates.add(new Date(curTime));
                curTime += interval;
            }
            System.out.println("Total date: "+dates.size());
            for (int i = 0; i < 10; i++) {
                    Date lDate = (Date) dates.get(i);
                    tenDates.add(lDate);
                    String ds = formatter.format(lDate);
                    System.out.println(i+" Dates is ..." + ds);
            }

            return tenDates;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dates;
    }
}
