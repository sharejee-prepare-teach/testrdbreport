package sortsetob;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by DELL on 10/2/2018.
 */
public class Student {
    private String studentname;
    private int rollno;
    private int studentage;

    public Student(int rollno,String studentname, int studentage) {
        this.studentname = studentname;
        this.rollno = rollno;
        this.studentage = studentage;
    }

    public Student() {
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public int getStudentage() {
        return studentage;
    }

    public void setStudentage(int studentage) {
        this.studentage = studentage;
    }

    /*Comparator for sorting the list by Student Name*/
    public static Comparator<Student> StuNameComparator = new Comparator<Student>() {

        public int compare(Student s1, Student s2) {
            String StudentName1 = s1.getStudentname().toUpperCase();
            String StudentName2 = s2.getStudentname().toUpperCase();

            //ascending order
            return StudentName1.compareTo(StudentName2);

            //descending order
            //return StudentName2.compareTo(StudentName1);
        }
    };

    /*Comparator for sorting the list by roll no*/
    public static Comparator<Student> StuRollno = new Comparator<Student>() {

        public int compare(Student s1, Student s2) {

            int rollno1 = s1.getRollno();
            int rollno2 = s2.getRollno();

	   /*For ascending order*/
            return rollno1-rollno2;

	   /*For descending order*/
            //rollno2-rollno1;
        }};
    @Override
    public String toString() {
        return "[ rollno=" + rollno + ", name=" + studentname + ", age=" + studentage + "]";
    }
}

class Details{
    public static void main(String args[]){
        ArrayList<Student> arraylist = new ArrayList<Student>();
        arraylist.add(new Student(101, "Zues", 26));
        arraylist.add(new Student(505, "Abey", 24));
        arraylist.add(new Student(809, "Vignesh", 32));
        arraylist.add(new Student(503, "Abey", 242));

	   /*Sorting based on Student Name*/
        System.out.println("Student Name Sorting:");
        Collections.sort(arraylist, Student.StuNameComparator);

        for(Student str: arraylist){
            System.out.println(str);
        }

	   /* Sorting on Rollno property*/
        /*System.out.println("RollNum Sorting:");
        Collections.sort(arraylist, Student.StuRollno);
        for(Student str: arraylist){
            System.out.println(str);
        }*/
    }
}
