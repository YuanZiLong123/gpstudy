package base.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @date 2020-06-02 14:24
 */
public class HashMapSameKeyTest {

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();

        map.put(1,1 );
        map.put(1,1 );
        map.put(1,1 );
        map.put(1,1 );
        map.put(1,1 );
        map.put(1,1 );
        map.put(1,1 );
        map.put(1,1 );
        System.out.println(map.size());
    }

}
