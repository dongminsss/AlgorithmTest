import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        ArrayDeque<Character> dq = new ArrayDeque<>();
        dq.push(s.charAt(0));
        for(int i = 1; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!dq.isEmpty() && c == ')' && dq.peek() == '(') {
                dq.pop();
            } 
            if(c == '(') dq.push(c);
        }
        
        return dq.isEmpty();
    }
}