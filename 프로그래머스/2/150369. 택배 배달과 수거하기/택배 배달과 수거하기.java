import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delIdx = n - 1;
        int pickIdx = n - 1;
        
        while(true) {
            while( delIdx >= 0 && deliveries[delIdx] == 0) delIdx--;
            while(pickIdx >= 0 && pickups[pickIdx] == 0) pickIdx--;
            
            if(delIdx < 0 && pickIdx < 0) break;
            
            int maxIdx = Math.max(delIdx, pickIdx);
            
            answer += (maxIdx + 1) * 2L;
            
            int amount = cap;
            while (delIdx >= 0 && amount > 0) {
                if (deliveries[delIdx] <= amount) {
                    amount -= deliveries[delIdx];
                    deliveries[delIdx] = 0;
                    delIdx--;
                } else {
                    deliveries[delIdx] -= amount;
                    amount = 0;
                }
            }

            amount = cap;
            while (pickIdx >= 0 && amount > 0) {
                if (pickups[pickIdx] <= amount) {
                    amount -= pickups[pickIdx];
                    pickups[pickIdx] = 0;
                    pickIdx--;
                } else {
                    pickups[pickIdx] -= amount;
                    amount = 0;
                }
            }
            
        }
        
        
        return answer;
    }
}