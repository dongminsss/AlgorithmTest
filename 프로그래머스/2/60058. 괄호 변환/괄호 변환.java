import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        if(isCorrect(p)) {
            answer = p;
        } else {
            answer = recursion(p);
        }
        return answer;
    }
    
    private String recursion(String w) {
        if(w.isEmpty()) return "";
        String[] b = balanceString(w);
        String u = b[0];
        String v = b[1];
        
        if(isCorrect(u)) {
            return u + recursion(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('(').append(recursion(v)).append(')');
            StringBuilder uu = new StringBuilder(u.substring(1, u.length()-1));
            for(int i = 0; i<uu.length(); i++) {
                char c = uu.charAt(i);
                uu.setCharAt(i, c == '(' ? ')':'(' );
            }
            return sb.append(uu.toString()).toString();
        }
    }
    
    
    private boolean isCorrect(String p) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : p.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    
    private String[] balanceString(String s) {
        int count1 = 0;
        int count2 = 0;
        String[] result = new String[2];
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == ')') {
                count1++;
            } else {
                count2++;
            }
            if(count1 == count2) {
                result[0] = s.substring(0, i+1);
                result[1] = s.substring(i+1, s.length());
                break;
            }
        }
        return result;
    }
}