package com.yzl.jdk8;



import java.util.*;
import java.util.stream.Collectors;

/**
 * @author admin
 * @date 2020-07-03 13:36
 */
public class OptionalTest {

    public static void main(String[] args) {

        listToString();
    }


    public static  void listToString(){

        List<Integer> rowNumbers =null;

       String s
         =Optional.ofNullable(rowNumbers)
                .map(e->  rowNumbers.stream().map(o->o.toString()).collect(Collectors.joining(",")))
       .orElse("1");

        System.out.println(s);
    }




    public static  void checkNull(String o){
     String s =   Optional.ofNullable(o).orElse("null");

        System.out.println(s);
    }

}
