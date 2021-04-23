package union;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class P_368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // 保存每个符合固定特征的集合
        List<List<Integer>> list = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            List<Integer> element = new LinkedList<>();
            element.add(i);
            list.add(new LinkedList<>(element));
        }



        // 查找最大的集合
        Iterator<List<Integer>> iterator = list.iterator();
        List<Integer> max = iterator.next();
        while (iterator.hasNext()) {
            List<Integer> next = iterator.next();
            if (next.size() > max.size()) {
                max = next;
            }
        }
        return max;
    }
}
