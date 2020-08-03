package base.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author admin
 * @date 2020-07-03 13:54
 */
public class StreamTest {


    public static void main(String[] args) {
        reduce();
    }



    public static  void map(){
        List<Integer> numbers = Arrays.asList(-1, -2, 0, 4, 5);
        numbers.stream().map( n -> Math.abs(n)).forEach(n ->  System.out.println("Element abs: " + n));

    }

    public static void flatMap(){
        List<String> list = Arrays.asList("1 2", "3 4", "5 6");
        list.stream().map(item -> Arrays.stream(item.split(" "))).forEach(n ->n.forEach(System.out::println));
        list.stream().flatMap(item -> Arrays.stream(item.split(" "))).forEach(System.out::println);
    }


    public static void filter(){
        List<Integer> numbers = Arrays.asList(-1, -2, 0, 4, 5);
        numbers.stream().filter(e->e>0).forEach(System.out::println);
    }


    public static void reduce(){
        List<Integer> numbers = Arrays.asList(-1, -2, 0, 4, 5);
        Integer total = numbers.stream().reduce((a,b)->a+b).get();
        System.out.println(total);
    }

    public static void collectTest(){
        List<Integer> numbers = Arrays.asList(-1, -2, 0, 4, 5);

        List<Integer> abss = numbers.stream().map( n -> Math.abs(n)).collect(Collectors.toList());

        System.out.println("Abs list: " + abss);
    }
}
