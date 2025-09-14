import java.util.*;

class Solution {
    public long solution(int[] weights) {
        Map<Integer, Integer> map = new HashMap<>();
        int[][] ratios = {{1,1}, {2,3}, {1,2}, {3,4}};
        long answer = 0;
        
        for(int w : weights) {
            map.put(w, map.getOrDefault(w,0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort(null);
        for(int w : list) {
            int count = map.get(w);
            
            for(int[] ratio : ratios) {
                int up = ratio[0], down = ratio[1];
                
                if ((w * down) % up != 0) continue;

                int target = (w * down) / up;
                if(!map.containsKey(target)) continue;
                
                int num = map.get(target);
                if(w == target) {
                    answer += (long)count * (count -1) / 2;
                } else if ( w < target) {
                    answer += (long)count * num;
                }
                
            }
        }
        return answer;
    }
}