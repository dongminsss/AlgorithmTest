import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        ArrayDeque<Character> dq = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if(!dq.isEmpty()) {
                if(c == ')' && dq.peek() == '(') dq.pop();
                if(c == '(') dq.push(c);
            } else {
                dq.push(c);
            }
        }
        
        if(!dq.isEmpty()) return false;
        return true;
    }
}