import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Ron Rith on 9/11/2018.
 */
public class TestfilterDuplicate {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static void main(String args[]){
        System.out.println("Employees Size: " +getEmployees().size());
        List<Employee> employees = getDuplicateEmployees(getEmployees());
        List<ReportEmployee> reportEmployees = getDuplicateEmployeeName(employees);
        for(ReportEmployee reportEmployee: reportEmployees){
            System.out.println("ReEmployeeName: " +reportEmployee.geteName());
        }
       /*
        List<ReportEmployee> reportEmployees = getDuplicateEmployeeName(getEmployees());
        for(ReportEmployee reportEmployee: reportEmployees){
            System.out.println(reportEmployee.geteName()+"; "+reportEmployee.getDay1()+" ; "+reportEmployee.getTotalAmount());
        }*/
    }
    public static Map<String, Integer> getDuplicateItems(List<String> strings){
        Map<String, Integer> counts = new HashMap<>();

        for (String str : strings) {
            if (counts.containsKey(str)) {
                counts.put(str, counts.get(str) + 1);
            } else {
                counts.put(str, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        return counts;
    }

    public static List<ReportEmployee> getDuplicateEmployeeName(List<Employee> employee){
        Map<String, Object> counts = new HashMap<>();
        List<Employee> employeeList = new ArrayList<>();
        List<ReportEmployee> reportEmployeeList = new ArrayList<>();

        for (Employee em : employee) {
            if (counts.containsKey(em.geteName())) {
                /*counts.put(em.geteName(), counts.get(em.geteName()) + 1);*/
                employeeList.add(em);
                counts.put(em.geteName(),employeeList);
            } else {
                counts.put(em.geteName(),employeeList);
            }
        }

        for (Map.Entry ent : counts.entrySet()) {
            for (Object obj : Arrays.asList(ent.getValue())) {
                List<Employee> employeeList1 = (List<Employee>) obj;
                if (employeeList1 != null) {
                    String eName = "";
                    String day1WorkDay = "";
                    Double totalMoney = 0D;

                    ReportEmployee reportEmployee = new ReportEmployee();
                    for (int i = 0; i < employeeList1.size(); i++) {
                        eName = employeeList1.get(i).geteName();
                        if(i == 0){
                            day1WorkDay = employeeList1.get(i).getWorkDay();
                            totalMoney += employeeList1.get(i).getFood();
                        }
                    }
                    reportEmployee.seteName(eName);
                    reportEmployee.setDay1(day1WorkDay);
                    reportEmployee.setTotalAmount(totalMoney);
                    reportEmployeeList.add(reportEmployee);
                }
            }
        }
        System.out.println("ReportE Size: "+reportEmployeeList.size());
        return reportEmployeeList;
    }

    // Has
    private static List<Employee> getEmployees(){
        List<Employee> employees = new ArrayList<>();

        for(int i =0;i<10;i++){
            Date date = null;
            try {
                date = sdf.parse((1+i)+"/12/2018");
            }catch (Exception e){
                e.printStackTrace();
            }
            Employee employee = new Employee();
            employee.seteNo(i);
            employee.seteName("Dara"+i);
            employee.setFood(10000D);
            employee.setWorkDay("X");
            employee.setDateFrom(date);
            employees.add(employee);
        }
        Date date = null;
        try {
            date = sdf.parse("02/12/2018");
        }catch (Exception e){
            e.printStackTrace();
        }

        Employee employee = new Employee();
        employee.seteNo(1);
        employee.seteName("Dara0");
        employee.setFood(10000D);
        employee.setWorkDay("1");
        employee.setDateFrom(date);
        employees.add(employee);
        return employees;
    }


    private static Employee getEmployee2(List<Employee> employees, String name, Date date) {
        if (employees != null) {
            for (Employee employee : employees) {
                if (name.equals(employee.geteName()) && date.compareTo(employee.getDateFrom())==0) {
                    System.out.println("------search-----");
                    System.out.println("Parameter date: "+date);
                    System.out.println("Employee name: "+employee.geteName());
                    System.out.println("Employee food:"+employee.getFood());
                    System.out.println("Employee date from: "+employee.getDateFrom());
                    System.out.println("------end search-----");
                    return employee;
                }
            }
        }
        return null;
    }

    private static List<Employee> getEmployee2(List<Employee> employees, String name) {
        List<Employee> emp = new ArrayList<>();
        if (employees != null) {
            for (Employee employee : employees) {
                if (name.equals(employee.geteName())) {
                    System.out.println("------search-----");
                    System.out.println("Employee name: "+employee.geteName());
                    System.out.println("Employee food:"+employee.getFood());
                    System.out.println("Employee date from: "+employee.getDateFrom());
                    System.out.println("------end search-----");
                    emp.add(employee);
                }
            }
        }
        return null;
    }

    // Has not
    //getDuplicateEmployees from start date to end date
    public static List<Employee> getDuplicateEmployees(List<Employee> employees){
        List<Date> dates = new ArrayList<>();

        String str_date ="01/12/2018";
        String end_date ="31/12/2018";

        dates = (List<Date>) GenerateDate.get10Days(str_date,end_date);
        System.out.println("current employees");
        for (Employee e : getEmployees()) {
            System.out.println("EName: " + e.geteName());
            System.out.println("DateFrom: " + e.getDateFrom());
        }

        List<Employee> emps = getEmployee2ByDate(getEmployees(),dates);

        if (emps != null) {
            System.out.println("Size emps: " + emps.size());
        }
        return emps;
    }

    // get Employee by start date and end date para
    private static List<Employee> getEmployee2ByDate(List<Employee> employees,List<Date> dates) {
        List<Employee> emp = new ArrayList<>();
        if (employees != null && dates != null) {
            for (Employee employee : employees) {
                for (int i = 0; i < dates.size(); i++) {
                    if (dates.get(i).compareTo(employee.getDateFrom()) == 0) {
                        System.out.println("------search-----");
                        System.out.println("Employee name: " + employee.geteName());
                        System.out.println("Employee food:" + employee.getFood());
                        System.out.println("Employee date from: " + employee.getDateFrom());
                        System.out.println("------end search-----");
                        emp.add(employee);
                    }
                }
            }
            return emp;
        }
        return null;
    }


}

class Employee{
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
class ReportEmployee{
    private String eName;
    private String day1;
    private String day2;
    private Double totalAmount;
    private String day1WorkDay;
    private String day2WorkDay;

    public ReportEmployee() {
    }

    public ReportEmployee(String eName, String day1, String day2, Double totalAmount, String day1WorkDay, String day2WorkDay) {
        this.eName = eName;
        this.day1 = day1;
        this.day2 = day2;
        this.totalAmount = totalAmount;
        this.day1WorkDay = day1WorkDay;
        this.day2WorkDay = day2WorkDay;
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

    public String getDay1WorkDay() {
        return day1WorkDay;
    }

    public void setDay1WorkDay(String day1WorkDay) {
        this.day1WorkDay = day1WorkDay;
    }

    public String getDay2WorkDay() {
        return day2WorkDay;
    }

    public void setDay2WorkDay(String day2WorkDay) {
        this.day2WorkDay = day2WorkDay;
    }
}