package filter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by DELL on 9/19/2018.
 */
public class RemoveDuplicate {
    public static void main(String args[]){
        /*
        *
        * Remove duplicates using LinkedHashSet
        *
        */

        List<String> al1 = new ArrayList<>();
        al1.add("A");
        al1.add("A");
        al1.add("B");
        al1.add("B");
        al1.add("C");
        al1.add("C");

        System.out.println("\tLINKED HASH SET:");
        System.out.println("Before removal: " + al1);

        Set<String> hs1 = new LinkedHashSet<>(al1);
        List<String> al2 = new ArrayList<>(hs1);

        System.out.println("After removal: " + al2);

        /*
        *
        * Remove duplicates with a nested loop
        *
        */

        ArrayList<String> al3 = new ArrayList<>();
        al3.add("A");
        al3.add("A");
        al3.add("B");
        al3.add("B");
        al3.add("C");
        al3.add("C");

        System.out.println("\n\tNESTED LOOP:");
        System.out.println("Before removal: " + al3);

        for(int i = 0; i < al3.size(); i++) {
            for(int j = i + 1; j < al3.size(); j++) {
                if(al3.get(i).equals(al3.get(j))){
                    al3.remove(j);
                    j--;
                }
            }
        }

        System.out.println("After removal: " + al3);

        /*
        *
        * Remove duplicates using a dedicated nested loop method
        *
        */

        ArrayList<String> al4 = new ArrayList<>();
        al4.add("A");
        al4.add("A");
        al4.add("B");
        al4.add("B");
        al4.add("C");
        al4.add("C");

        System.out.println("\n\tREMOVE DUPLICATES METHOD:");
        System.out.println("Before removal: " + al4);
        removeDuplicates(al4);
        System.out.println("After removal: " + al4);
    }

    public static void removeDuplicates(ArrayList<?> al) {
        for(int i = 0; i < al.size(); i++) {
            for(int j = i + 1; j < al.size(); j++) {
                if(al.get(i).equals(al.get(j))){
                    al.remove(j);
                    j--;
                }
            }
        }
    }
}
