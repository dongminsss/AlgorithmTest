import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            int count = 0;
            while(count<index) {
                c++;
                if(c > 'z') c = 'a';
                
                if(skip.contains(String.valueOf(c))) continue;
                count++;
            }
            sb.append(c);
        }
        
        return sb.toString();
    }
}