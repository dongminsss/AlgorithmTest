import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int currentTangerine = 0;
        List<Integer> tangerineCounts = new ArrayList<>();
        HashMap<Integer, Integer> tangerineMap = new HashMap<>();
        for(int i : tangerine) {
            if(tangerineMap.get(i) == null) {
                tangerineMap.put(i , 1);
            } else {
                tangerineMap.put(i , tangerineMap.get(i) + 1);
            }
        }
        for(Integer value : tangerineMap.values()) {
            tangerineCounts.add(value);
        }
        Collections.sort(tangerineCounts);
        int startIndex = tangerineCounts.size()-1;
        for(int i = startIndex; i>=0; i--) {
            k -= tangerineCounts.get(i);
            answer++;
            if(k<=0) {
                break;
            }
        }
        
        
        return answer;
    }
}