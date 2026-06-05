import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        ArrayDeque<String[]> dq = new ArrayDeque<>();
        int idx = 0;
        for(String[] plan : plans) {
            plan[1] = replaceMinute(plan[1]);
        }
        Arrays.sort(plans, (o1, o2) -> Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]));
        // System.out.println(Arrays.deepToString(plans));
        
        for(int i = 0; i<plans.length-1; i++) {
            String name = plans[i][0];
            int startTime = Integer.parseInt(plans[i][1]);
            int playable = Integer.parseInt(plans[i][2]);
            int nextStart = Integer.parseInt(plans[i+1][1]);
            
            int available = nextStart - startTime;
            
            if(available >= playable) {
                answer[idx++] = name;
                int remain = available - playable;
                
                while(!dq.isEmpty() && remain >0) {
                    String[] paused = dq.pop();
                    int pausedTime = Integer.parseInt(paused[1]);
                    if(pausedTime <= remain) {
                        answer[idx++] = paused[0];
                        remain -= pausedTime;
                    } else {
                        paused[1] = String.valueOf(pausedTime - remain);
                        dq.push(paused);
                        remain = 0;
                    }
                }
            } else {
                int remain = playable - available;
                dq.push(new String[]{name, String.valueOf(remain)});
            }
        }
        answer[idx++] = plans[plans.length-1][0];
        
        while(!dq.isEmpty()) {
            answer[idx++] = dq.pop()[0];
        }
        return answer;
    }
    
    String replaceMinute(String s) {
        int count = 0;
        String[] arr = s.split(":");
        count += Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
        return String.valueOf(count);
    }
    
    
}