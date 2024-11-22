import java.util.*;
class Solution {
    static final String IN_FIX = "님이 들어왔습니다.";
    static final String OUT_FIX = "님이 나갔습니다.";
    
    public String[] solution(String[] record) {
        Map<String, String> table = new HashMap<>();
        int count = 0;
        for(String str : record) {
            String[] arr = str.split(" ");
            
            if(arr[0].equals("Change") || arr[0].equals("Enter")) {
                table.put(arr[1], arr[2]);
            } 
            if(arr[0].equals("Enter") || arr[0].equals("Leave")) count++;
            
        }
        
        String[] answer = new String[count];
        
        int idx = 0;
        for(int i = 0; i<record.length; i++) {
            String status = record[i].split(" ")[0];
            String uid = record[i].split(" ")[1];
            
            if(status.equals("Enter")) {
                answer[idx++] = table.get(uid) + IN_FIX;
            } else if(status.equals("Leave")){
                answer[idx++] = table.get(uid) + OUT_FIX;
            }
        }
        
        
        return answer;
    }
}