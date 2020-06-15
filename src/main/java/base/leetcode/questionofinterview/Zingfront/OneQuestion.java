package base.leetcode.questionofinterview.Zingfront;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author admin
 * @date 2020-06-11 17:57
 *
 * 某公司内有 4 个项目组，项目组 A、B、C、D，项目组A现有10⼈人，项目组B现有7⼈人，项目组C现
 * 有5⼈人，项目组D现有4⼈人。为了了实现跨项目组协作，公司决定每月从⼈人数最多的项目组中抽调 3 ⼈人
 * 出来，到其他剩下 3 组中，每组 1 ⼈人，这称之为⼀一次调整优化（亦即经过第⼀一次调整后，A组有7
 * ⼈人，B组有8⼈人，C组有6⼈人，D组有5⼈人）。
 * 那么请问，经过十年的优化调整后，各项目组各有⼏几⼈人？
 * 编程求解该问题，并思考是否为最优解。
 *
 */
public class OneQuestion {

    public static void main(String[] args) {

        Item itemA = new Item("A",10 );
        Item itemB = new Item("B",7 );
        Item itemC = new Item("C",5 );
        Item itemD = new Item("D",4 );


        List<Item> list = new ArrayList<>();

        list.add(itemA);
        list.add(itemB);
        list.add(itemC);
        list.add(itemD);

        int i =1;

        do {
            Collections.sort(list);
            Item item = null;
            for (int j=0;j<4;j++){
                item = list.get(j);

                if (j!=3){
                    item.setNumber(item.getNumber()+1);
                }else {
                    item.setNumber(item.getNumber()-3);
                }
            }
            i++;
        }while (i<=10*12);

        for (Item item:list
             ) {
            System.out.println(item);
        }

    }

}
