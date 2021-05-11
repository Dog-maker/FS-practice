package LK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个整数 n 和一个整数数组 rounds 。有一条圆形赛道由 n 个扇区组成，扇区编号从 1 到 n 。现将在这条赛道上举办一场马拉松比赛，该马拉松全程由 m 个阶段组成。其中，第 i 个阶段将会从扇区 rounds[i - 1] 开始，到扇区 rounds[i] 结束。举例来说，第 1 阶段从 rounds[0] 开始，到 rounds[1] 结束。
 *
 * 请你以数组形式返回经过次数最多的那几个扇区，按扇区编号 升序 排列。
 *
 * 输入：n = 4, rounds = [1,3,1,2]
 * 输出：[1,2]
 * 解释：本场马拉松比赛从扇区 1 开始。经过各个扇区的次序如下所示：
 * 1 --> 2 --> 3（阶段 1 结束）--> 4 --> 1（阶段 2 结束）--> 2（阶段 3 结束，即本场马拉松结束）
 * 其中，扇区 1 和 2 都经过了两次，它们是经过次数最多的两个扇区。扇区 3 和 4 都只经过了一次。
 *
 */
public class lk1560 {

    public static void main(String[] args) {
//        lk1560 lk1560 = new lk1560();
//        lk1560.mostVisited(2, new int[]{2,1,2,1,2,1,2,1,2});
        System.out.println(0%2);
        String str="abc";
        String str1 = new String("abc");
        System.out.println(str.hashCode() == str1.hashCode());
        System.out.println(str == str1);
    }

    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] ar = new int[n];

        int run;
        int qu = rounds[0];
        for(int i = 1;i<rounds.length;i++){
            while ( qu != rounds[i]){
                ar[qu-1]++;
                if(qu == n)
                    qu = 0;
                qu++;
            }
        }

        ar[rounds[rounds.length-1]-1]++;

        int max = 0;
        for (int i : ar){
            if (i>max)
                max = i;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<ar.length;i++){
            if (ar[i] == max){
                list.add(i+1);
            }
        }
        return list;
    }

}
