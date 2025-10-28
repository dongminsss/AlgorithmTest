import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> gemsList = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> gemsTable = new HashMap<>();
        
        int totalSize = gemsList.size();
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        
        for(int i = 0; i < gems.length; i++) {
            gemsTable.put(gems[i], gemsTable.getOrDefault(gems[i], 0) + 1);
            
            while(gemsTable.size() == totalSize) {
                int len = i - start + 1;
                if(len < minLen) {
                    answer[0] = start + 1;
                    answer[1] = i + 1;
                    minLen = len;
                }
                
                gemsTable.put(gems[start], gemsTable.get(gems[start]) - 1);
                
                if(gemsTable.get(gems[start]) == 0) {
                    gemsTable.remove(gems[start]);
                }
                start++;
                
            }
        }
        
        return answer;
    }
}