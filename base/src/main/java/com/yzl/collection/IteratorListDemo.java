package com.yzl.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author admin
 * @date 2020-08-25 13:14
 */
public class IteratorListDemo {


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        Iterator iterator  = list.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
