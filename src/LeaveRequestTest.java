public class LeaveRequestTest {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Double la1 = 1d;
        Double la1And5 = 0.5d;

        Double ladH = 2.5d;
        Double ladN = 2.0d;
        System.out.println(ladH/2);//1.25
        System.out.println(ladN/2);//1.0

        System.out.println("-------");
        System.out.println(ladH%2);//0.5
        System.out.println(ladN%2);//0.0
        System.out.println(0.5%2);//0.5

        System.out.println(1%2);//1.
        System.out.println(2%2);//0.0
        // Leave Amount Has 1/5
        String laMs = "";

        Double num1 = 1d;
        Double num2 = 2d;
        Double num3 = 3d;
        Double numZeroAnd5 = 0.5d;
        Double num1And5 = 1.5d;
        Double num2And5 = 2.5d;
        Double num3And5 = 3.5d;

        Double result = 0D;
        result = num2%2;
        if (num2!= 1) {
            if (result != 0.0) {
                laMs = "Num2 H";
                System.out.println(laMs);
                //Go to 1 condition more
            } else {
                laMs = "Num2 N";
                System.out.println(laMs);
                // Don't go to 1 condition
            }
        }
        // Except 1 Amount of condition are 4

    }
}
