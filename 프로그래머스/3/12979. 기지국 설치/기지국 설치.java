import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = w * 2 + 1;
        int start = 1;
        for(int i = 0; i<stations.length; i++){
            int length = (stations[i] - w) - start;
            if(length > 0) {
                answer += length / range;
                if(length % range > 0) answer += 1;
            }
            start = stations[i] + w  + 1;
        }
        int lastLen = n - start + 1;
        if(lastLen > 0) {
            answer += lastLen / range;
            if(lastLen % range > 0) answer += 1;
        }

        return answer;
    }
}