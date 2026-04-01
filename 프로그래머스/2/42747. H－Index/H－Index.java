import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int total = citations.length;
        int answer = citations[citations.length-1];
        while(answer > 0) {
            int h = 0;
            for(int citation : citations) {
                if(citation >= answer) h++; 
            }
            if(h >= answer && total - h <= h) break;
            answer--;
        }
        return answer;
    }
}