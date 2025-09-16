import java.util.*;

class Solution {
    boolean solution(String s) {
        if(s.charAt(0) == ')') return false;
        
        ArrayDeque<Character> deque = new ArrayDeque<>();
         boolean answer = true;
        for(char c : s.toCharArray()) {
            if(c == ')' && !deque.isEmpty()) {
                char ch = deque.pop();
                if(ch != '(') answer = false;
            } else {
                deque.add(c);
            }
        }
        if(!deque.isEmpty()) answer = false;    

        return answer;
    }
}