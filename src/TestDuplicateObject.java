import java.util.*;

/**
 * Created by DELL on 9/19/2018.
 */
public class TestDuplicateObject {
    public static void main(String[] args) throws Exception {
        SampleFilter();
        List<Employee> employees = TestfilterDuplicate.getEmployees();
        System.out.println("-------Before Remove: "+employees.size());
        displayEmployee(employees);
        List<Employee> listWithoutDuplicates = getEmployeesNotDup(employees);
        System.out.println("--------After Remove: "+listWithoutDuplicates.size());
        displayEmployee(listWithoutDuplicates);

    }
    public List<Employee> getEmployee(){
        List<Employee> employees = TestfilterDuplicate.getEmployees();
        return employees;
    }
    public static void displayEmployee(List<Employee> employees){
        for(Employee employee : employees){
            System.out.println(employee.geteName()+ "; "+employee.getFood());
        }
    }

    public static List<Employee> getEmployeesNotDup(List<Employee> employees){
            for(int i = 0; i < employees.size(); i++) {
                for(int j = i + 1; j < employees.size(); j++) {
                    if(employees.get(i).geteName().equals(employees.get(j).geteName())){
                        employees.remove(j);
                        j--;
                    }
                }
            }
            return employees;
    }
    public static void SampleFilter(){
        List<String> list = new ArrayList<>();
        list.add("Ashok");
        list.add("Vinod");
        list.add("Kumar");
        list.add("Ashok");
        list.add("Mariyala");
        list.add("Venkata");
        list.add("Mariyala");
        list.add("Vinod");
        list.add("Ashok");
        list.add("Kumar");

        Map<String, Integer> duplicates = new HashMap<>();

        for (String str : list) {
            if (duplicates.containsKey(str)) {
                duplicates.put(str, duplicates.get(str) + 1);
            } else {
                duplicates.put(str, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : duplicates.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
