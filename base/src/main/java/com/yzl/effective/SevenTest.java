package effective;

import java.util.ArrayList;
import java.util.List;

public class SevenTest {


    public static void main(String[] args) {
        SevenCaseInsensitiveString s = new SevenCaseInsensitiveString("ok");
        String string = "ok";
        System.out.println(s.equals(string));
        System.out.println(string.equals(s));
        List list = new ArrayList();
        list.add(s);
        list.add(string);
        System.out.println(list.contains(s));
    }
}
