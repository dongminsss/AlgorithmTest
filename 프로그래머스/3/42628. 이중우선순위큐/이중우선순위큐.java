import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        List<Integer> pq = new ArrayList<>();
        
        for(int i = 0; i<operations.length; i++) {
            String[] arr = operations[i].split(" ");
            if(arr[0].equals("I")) {
                pq.add(Integer.parseInt(arr[1]));
                pq.sort(null);
            }
            if(arr[0].equals("D")) {
                
                if(!pq.isEmpty()) {
                    if(arr[1].equals("-1")) pq.remove(0);
                    if(arr[1].equals("1")) pq.remove(pq.size()-1);
                }
                
            }
        }
        
        
        int[] answer = new int[2];
        
        if(!pq.isEmpty()){
            answer[0] = pq.get(pq.size()-1);
            answer[1] = pq.get(0);
        } else {
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }
}