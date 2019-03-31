package countletterstring;

/**
 * Created by Rith on 3/31/2019.
 */
public class CountSample {
    public static void main(String []args) {
        String str = "Hello World! I am here. I am glade to meet you. Please keep in touch!";
        String stCount = getStr40(str);
        System.out.println("str40: " + getStr40(str));
    }

    public static String getStr40(String oldStr) {
        String str40 = "";
        if (oldStr.length() > 40) {
            for (int i = 0; i < oldStr.length(); i++) {
                if (i < 40) {
                    str40 += oldStr.charAt(i);
                }
            }
            str40 += "...";
            return str40;
        }
        return oldStr;
    }
}
