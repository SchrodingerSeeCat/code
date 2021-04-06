package hash;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class P_781 {
    public int numRabbits(int[] answers) {
        if (answers.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : answers) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int count = 0;
        int key = 0, value = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();
            count = count + (key + value) / (key + 1) * (key + 1);
        }
        return count;
    }
}
