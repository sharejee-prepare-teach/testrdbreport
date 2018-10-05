package filter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DELL on 9/19/2018.
 */
public class FilterStringFromArrList {
    public static void main(String args[]){
        Person person = getPersonFilter(getPeople(),1,"name1",new Date());
        System.out.println(person.toString());
    }
    public static void getFilterAString(){
        List<String> list = new ArrayList<>();
        list.add("behold");
        list.add("bend");
        list.add("bet");
        list.add("bear");
        list.add("beat");
        list.add("become");
        list.add("begin");

        List <String> listClone = new ArrayList<String>();
        for (String string : list) {
            //"(?i)(bea).*") search contain
            if(string.matches("bear")){
                listClone.add(string);
            }
        }
        System.out.println(listClone);
    }
    public static Person getPersonFilter(List<Person> personList,Integer id,String name, Date startWorkDate){
        for(Person person: personList){
            if(person.getName().equalsIgnoreCase(name) && person.getId() == id && person.getStartWorkDate().compareTo(startWorkDate)==0){
                return person;
            }
        }
        return null;
    }
    public static List<Person> getPeople(){
        List<Person> personList = new ArrayList<>();
        for(int i =0;i<3;i++){
            Person person = new Person();
            person.setId(i);
            person.setName("Name"+i);
            person.setStartWorkDate(new Date());
            person.setEndWorkDate(new Date());
            personList.add(person);
        }
        return personList;
    }
}
class Person{
    private int id;
    private String name;
    private Date startWorkDate;
    private Date endWorkDate;


    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int id, String name, Date startWorkDate, Date endWorkDate) {
        this.id = id;
        this.name = name;
        this.startWorkDate = startWorkDate;
        this.endWorkDate = endWorkDate;
    }

    public Date getStartWorkDate() {
        return startWorkDate;
    }

    public void setStartWorkDate(Date startWorkDate) {
        this.startWorkDate = startWorkDate;
    }

    public Date getEndWorkDate() {
        return endWorkDate;
    }

    public void setEndWorkDate(Date endWorkDate) {
        this.endWorkDate = endWorkDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startWorkDate=" + startWorkDate +
                ", endWorkDate=" + endWorkDate +
                '}';
    }
}
