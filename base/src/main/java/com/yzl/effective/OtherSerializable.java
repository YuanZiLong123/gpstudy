package effective;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class OtherSerializable implements Serializable {

    private String name;

    public OtherSerializable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Object readResolve() throws ObjectStreamException {
        OtherSerializable otherSerializable = new OtherSerializable("ceshi");

        return  otherSerializable;
    }



}
