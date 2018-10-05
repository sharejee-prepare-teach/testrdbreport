package sortsetob;

import java.util.*;

/**
 * Created by DELL on 10/2/2018.
 */
public class Person implements Comparable<Person>{
    private String firstName, lastName;

    public Person(String firstName, String lastName) { this.firstName = firstName; this.lastName = lastName;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getName() {return firstName + " " + lastName;}

    public int compareTo(Person p) {
        return lastName.compareTo(p.lastName);
    }
}

class FirstNameComparator implements Comparator<Person> {
    public int compare(Person p1, Person p2){
        return p1.getFirstName().compareTo(p2.getFirstName());
    }
}
class Test {
    public static void log(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Set<Person> people = new HashSet<>();
        people.add(new Person("Bob", "Jones"));
        people.add(new Person("Alice", "Yetti"));
        people.add(new Person("Alice2", "Yetti"));

        /*log("--------Sorted list:--------");
        List<Person> peopleList = new LinkedList<>();
        peopleList.addAll(people);
        Collections.<Person>sort(peopleList);
        for (Person p : peopleList) {
            log(p.getName());
        }

        log("-------TreeSet:---------");
        TreeSet<Person> treeSet = new TreeSet<Person>();
        treeSet.addAll(people);
        for (Person p : treeSet) {
            log(p.getName());
        }*/

        log("-------TreeSet (custom sort):--------");
        TreeSet<Person> treeSet2 = new TreeSet<Person>(new FirstNameComparator());
        treeSet2.addAll(people);
        System.out.println("people: "+people.size());
        System.out.println("treeSet2: "+treeSet2.size());
        /*for (Person p : treeSet2) {
            log(p.getName());
        }*/
    }
}

