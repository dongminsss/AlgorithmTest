import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i<sb.length(); i++) {
            
            ArrayDeque<Character> stack = new ArrayDeque<>();
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            for(int j = 0; j<sb.length(); j++) {
                char c = sb.charAt(j);
                if(!stack.isEmpty()) {
                    if(c == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else if(c == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if(c == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }
            }
            
            if(stack.isEmpty()) answer++;
        }
        return answer;
    }
}