import java.util.Date;

/**
 * Created by DELL on 9/19/2018.
 */
public class Employee {
    private Integer eNo;
    private String eName;
    private Date dateFrom;
    private String workDay;
    private Double food;

    public Integer geteNo() {
        return eNo;
    }

    public void seteNo(Integer eNo) {
        this.eNo = eNo;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Double getFood() {
        return food;
    }

    public void setFood(Double food) {
        this.food = food;
    }

    public String getWorkDay() {
        return workDay;
    }

    public void setWorkDay(String workDay) {
        this.workDay = workDay;
    }

    public Employee(Integer eNo, String eName, Date dateFrom, String workDay, Double food) {
        this.eNo = eNo;
        this.eName = eName;
        this.dateFrom = dateFrom;
        this.workDay = workDay;
        this.food = food;
    }

    public Employee() {
    }
}
