import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        ArrayDeque<String[]> dq = new ArrayDeque<>();
        int idx = 0;
        for(String[] p : plans) {
            p[1] = String.valueOf(replaceMinute(p[1]));
        }
        Arrays.sort(plans, (o1,o2) -> Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]));
        
        for(int i = 0; i<plans.length-1; i++) {
            String name = plans[i][0];
            int start = Integer.parseInt(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);
            int nextStart = Integer.parseInt(plans[i+1][1]);
            int available = nextStart - start;
            
            if(available >= playTime) {
                answer[idx++] = name;
                int remain = available - playTime;
                
                while(!dq.isEmpty() && remain > 0) {
                    String[] paused = dq.pop();
                    int pausedTime = Integer.parseInt(paused[1]);
                    if(pausedTime <= remain) {
                        remain -= pausedTime;
                        answer[idx++] = paused[0];
                    } else {
                        dq.push(new String[]{paused[0], String.valueOf(pausedTime - remain)});
                        remain = 0;
                    }
                }
            } else {
                dq.push(new String[]{name, String.valueOf(playTime - available)});
            }
        }
        
        answer[idx++] = plans[plans.length-1][0];
        
        while(!dq.isEmpty()) {
            answer[idx++] = dq.pop()[0];
        }
        
        return answer;
    }
    
    int replaceMinute(String str) {
        String[] arr = str.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}