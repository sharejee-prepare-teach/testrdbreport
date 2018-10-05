/**
 * Created by DELL on 9/19/2018.
 */
public class ReportEmployee {
    private String eName;
    private String day1;
    private String day2;
    private Double totalAmount;

    public ReportEmployee(String eName, String day1, String day2, Double totalAmount) {
        this.eName = eName;
        this.day1 = day1;
        this.day2 = day2;
        this.totalAmount = totalAmount;
    }

    public ReportEmployee() {
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getDay1() {
        return day1;
    }

    public void setDay1(String day1) {
        this.day1 = day1;
    }

    public String getDay2() {
        return day2;
    }

    public void setDay2(String day2) {
        this.day2 = day2;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
