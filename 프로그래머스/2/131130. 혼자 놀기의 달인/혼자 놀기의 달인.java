import java.util.*;

class Solution {
    List<Integer> count = new ArrayList<>();
    boolean[] visit;
    
    public int solution(int[] cards) {
        int len = cards.length;
        visit = new boolean[len];
        
        for(int i = 0; i<len; i++) {
            if(!visit[i]) {
                dfs(cards, cards[i], 0);
            }
        }
        
        int answer = 0;
        count.sort(Collections.reverseOrder());
        if(count.size() <= 1) {
            answer = 0;
        } else {
            answer = count.get(0) * count.get(1);
        }
        return answer;
    }
    
    private void dfs(int[] cards ,int start, int depth) {
        int idx = start - 1;
        if(visit[idx]) {
            count.add(depth);
            return;
        }
        visit[idx] = true;
        dfs(cards, cards[idx], depth + 1);
    }
}