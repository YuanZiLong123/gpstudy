package com.yzl.desigt.prototype.shallow;


import com.yzl.desigt.prototype.ReferenceDemo;

public class ShallowCloneDome implements  Cloneable {


    private ReferenceDemo referenceDemo;

    private String name;

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

    @Override
    public ShallowCloneDome clone(){
        ShallowCloneDome shallowCloneDome = new ShallowCloneDome();
        shallowCloneDome.setName(this.name);
        shallowCloneDome.setReferenceDemo(this.referenceDemo);
        return  shallowCloneDome;
    }
}
