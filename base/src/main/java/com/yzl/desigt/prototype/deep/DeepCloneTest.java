package com.yzl.desigt.prototype.deep;


import com.yzl.desigt.prototype.ReferenceDemo;

public class DeepCloneTest {

    public static void main(String[] args) {
        DeepCloneDome deepCloneDome = new DeepCloneDome();
        ReferenceDemo referenceDemo = new ReferenceDemo();
        deepCloneDome.setName("deep");
        deepCloneDome.setReferenceDemo(referenceDemo);

        DeepCloneDome otherDeepCloneDome = deepCloneDome.deepClone();

        System.out.println(deepCloneDome.getReferenceDemo() == otherDeepCloneDome.getReferenceDemo());
        System.out.println(deepCloneDome.getName() +"/"+ otherDeepCloneDome.getName());
    }
}
