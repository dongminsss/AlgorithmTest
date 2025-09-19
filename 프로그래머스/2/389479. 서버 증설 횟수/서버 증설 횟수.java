import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0; i<players.length; i++) {
            
            while(!dq.isEmpty() && i >= dq.peekFirst() ) {
                dq.removeFirst();
            }
            
            int currentServer = dq.size();
            int needServer = players[i] / m - currentServer;
            
            if(0 < needServer) {
                for(int j = 0; j<needServer; j++) {
                    dq.addLast(i + k);
                }
                answer += needServer;
            }
            
            
            
        }
        return answer;
    }
}