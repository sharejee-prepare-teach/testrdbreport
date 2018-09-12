package filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DELL on 9/11/2018.
 */
public class BeforeJava8 {
    public static void main(String[] args) {

        List<String> lines = getFilterResult(Arrays.asList("spring", "node", "mkyong"));


    }

    private static List<String> getFilterResult(List<String> stringList){
        List<String> result = getFilterOutput(stringList, "mkyong");
        for (String temp : result) {
            System.out.println(temp);    //output : spring, node
        }
        return result;
    }
    private static List<String> getFilterOutput(List<String> lines, String filter) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if ("mkyong".equals(line)) { // we dont like mkyong
                result.add(line);
            }
        }
        return result;
    }
}
