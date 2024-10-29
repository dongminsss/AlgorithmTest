import java.util.*;
class Solution {
    public int solution(int[] order) {
        
        ArrayDeque<Integer> convay = new ArrayDeque<>();
        int boxNumber = 1;
        int answer = 0;
        for(int i = 0; i<order.length; i++) {
            if(!convay.isEmpty() && convay.peek() == order[i]) {
                convay.pop();
                answer++;
            }
            
            while(order[i] > boxNumber && boxNumber <= order.length) {
                convay.push(boxNumber);
                boxNumber++;
            }
            if(order[i] == boxNumber) {
                answer++;
                boxNumber++;
            }
            if(boxNumber > order[i] && !convay.isEmpty() &&convay.peek() > order[i]) break;
            
        }
        
        return answer;
    }
}