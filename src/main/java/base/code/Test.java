package base.code;

/**
 * @author admin
 * @date 2020-07-23 15:41
 */
public class Test {

    public static void main(String[] args) {
        Q q = new Q();


    }

}



class P{
    static {
        System.out.println("static P is init");
    }

    {
        System.out.println(" P is init");
    }


    public P() {
        System.out.println("constructor P is init");
    }
}


class Q extends P{
    static {
        System.out.println("static Q is init");
    }

    {
        System.out.println(" Q is init");
    }


    public Q() {
        System.out.println("constructor Q is init");
    }
}
