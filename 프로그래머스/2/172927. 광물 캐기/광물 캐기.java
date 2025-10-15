import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        List<int[]> list = new ArrayList<>();
        int totalPicks = Arrays.stream(picks).sum();
        
        for(int i = 0; i<minerals.length && list.size() < totalPicks; i+=5) {
            
            int[] arr = new int[3];
            for(int j = i; j<i+5; j++){
                if(j >= minerals.length) break;
                if(minerals[j].equals("diamond")) {
                    arr[0]++;
                } else if(minerals[j].equals("iron")) {
                    arr[1]++;
                } else {
                    arr[2]++;
                }
            }
            list.add(arr);
        }
        list.sort((o1,o2) -> {
            int c = Integer.compare(o2[0], o1[0]);
            if (c != 0) return c;
            c = Integer.compare(o2[1], o1[1]);     
            if (c != 0) return c;
            return Integer.compare(o2[2], o1[2]);
        });
        int answer = 0;
        for(int i=0; i<picks[0]; i++) {
            if(!list.isEmpty()) {
                int[] arr = list.remove(0);
                answer += (arr[0] + arr[1] + arr[2]);
            }
        }
        for(int i= 0; i<picks[1]; i++) {
            if(!list.isEmpty()) {
                int[] arr = list.remove(0);
                answer += (arr[0]*5 + arr[1] + arr[2]);
            }
        }
        for(int i = 0; i<picks[2]; i++) {
            if(!list.isEmpty()) {
                int[] arr = list.remove(0);
                answer += (arr[0]*25 + arr[1]*5 + arr[2]);
            }
        }
        
        
        return answer;
    }
}