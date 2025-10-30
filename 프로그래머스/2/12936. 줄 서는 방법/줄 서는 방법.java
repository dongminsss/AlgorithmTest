import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> list = new ArrayList<>();
        long[] arr = new long[n+1];
        int[] answer = new int[n];
        arr[0] = 1;
        for(int i = 1; i<=n; i++) {
            list.add(i);
            arr[i] = arr[i-1] * i;
        }
        k--;
        
        for(int i = 0; i<n; i++) {
            long cases = arr[n-1-i];
            int idx = (int)(k/cases);
            answer[i] = list.remove(idx);
            k %= cases;
        }
        
        return answer;
    }
}