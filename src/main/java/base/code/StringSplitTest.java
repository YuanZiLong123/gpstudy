package base.code;

/**
 * @author admin
 * @date 2020-05-27 11:16
 */
public class StringSplitTest {


    public static void main(String[] args) {
        String str = "a,b,c,,";
        String[] ary = str.split(",");
// 预期大于 3，结果是 3
        System.out.println(ary.length);
    }
}
