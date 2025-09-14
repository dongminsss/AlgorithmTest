import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        List<int[]> list = new ArrayList<>();
        int firstIdx = 0;
        int lastIdx = 0;
        int[] answer = new int[2];
        int sum = sequence[0];
        int maxLen = sequence.length;
        while(lastIdx < maxLen ) {
            
            if(sum < k ) {
                lastIdx++;
                if(lastIdx < maxLen) sum+=sequence[lastIdx];
            } else if(sum > k) {
                sum-=sequence[firstIdx];
                firstIdx++;
                if(firstIdx > lastIdx) {
                    lastIdx++;
                    if(lastIdx < maxLen) sum+=sequence[lastIdx];
                }
            } else {
                list.add(new int[]{firstIdx, lastIdx});
                lastIdx++;
                if(lastIdx < maxLen) sum+=sequence[lastIdx];
            }
        }
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i<list.size(); i++) {
            int[] arr = list.get(i);
            if(min > Math.abs(arr[0] - arr[1])) {
                answer[0] = arr[0];
                answer[1] = arr[1];
                min = Math.abs(arr[0] - arr[1]);
            }
        }
        return answer;
    }
}