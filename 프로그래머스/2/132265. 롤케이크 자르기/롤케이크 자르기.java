import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> ch = new HashMap<>();
        Map<Integer, Integer> sh = new HashMap<>();
        int answer = 0;
        for(int i : topping) {
            sh.put(i, sh.getOrDefault(i, 0) + 1);
        }
        
        for(int i : topping) {
            sh.put(i, sh.get(i) - 1);
            if(sh.get(i) == 0) sh.remove(i);
            ch.put(i, ch.getOrDefault(i, 0) + 1);
            
            if(sh.size() == ch.size()) answer++;
        }
        
        
        
        
        return answer;
    }
    
}