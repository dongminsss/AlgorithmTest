import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        for(int i = 1; i<n+1; i++) {
            for(int j = 0; j<section.length; j++) {
                if(i == section[j]) {
                    answer++;
                    i += m;
                }    
            }
            
        }
        return answer;
    }
}