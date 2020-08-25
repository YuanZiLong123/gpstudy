package effective;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class TwoSingleton implements Serializable {

    private String name;

    private static  final  TwoSingleton INSTANCE = new TwoSingleton();

    private TwoSingleton() {
    }

    public static  synchronized TwoSingleton  getInstance(){
        return INSTANCE;
    }


    private Object readResolve() throws ObjectStreamException{
        return  INSTANCE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
