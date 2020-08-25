package com.yzl.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author admin
 * @date 2020-08-25 13:19
 */
public class ListRemoveDemo {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,2,3,4,5,6,7,8,9};

        List<Integer> list = Arrays.asList(array);

//        for (int i=0;i<list.size();i++){
//            list.remove(list.get(i));
//        }

        Iterator iterator = list.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
           // iterator.remove();
        }

        System.out.println(list.size());
    }

}
