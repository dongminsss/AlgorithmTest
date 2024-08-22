import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i = 0; i < discount.length; i++) {
            boolean countBoolean = false;
            int[] arr = new int[number.length];
            for(int j = 0; j< want.length; j++) {
                
                for(int k = 0; k< 10;k++) {
                    if(i + k >= discount.length) break;
                    if(want[j].equals(discount[i + k])) {
                        arr[j] += 1;
                    }
                
                }    
            }
            for(int j= 0; j < number.length; j++) {
                if(arr[j] != number[j]) countBoolean = true;
            }
            if(!countBoolean) answer++;
                
        }
        
        return answer;
    }
}