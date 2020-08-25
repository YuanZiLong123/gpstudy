package com.yzl.desigt.prototype.deep;

import com.yzl.desigt.prototype.ReferenceDemo;

import java.io.*;
import java.util.Objects;

public class DeepCloneDome implements  Cloneable, Serializable {


    private String name;

    private ReferenceDemo referenceDemo;


    public ReferenceDemo getReferenceDemo() {
        return referenceDemo;
    }

    public void setReferenceDemo(ReferenceDemo referenceDemo) {
        this.referenceDemo = referenceDemo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public DeepCloneDome deepClone(){
        ByteArrayInputStream bis = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            return (DeepCloneDome) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (Objects.nonNull(bis)){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.nonNull(bos)){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.nonNull(oos)){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.nonNull(ois)){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  null;
    }

}
