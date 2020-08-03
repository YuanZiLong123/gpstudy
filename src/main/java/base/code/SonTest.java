package base.code;

/**
 * @author admin
 * @date 2020-07-23 15:45
 */
public class SonTest {

    public static void main(String[] args) {
        A a = new B();

        ((B) a).talk();
    }
}



class A{

    public void  say(){
        System.out.println("parent is say");
    }

}


class B extends A{

    @Override
    public void say(){
        System.out.println("Son is say");
    }

    public void talk(){
        System.out.println("Son is talk");
    }

}