import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i<number.length(); i++) {
            int parseNumber = Character.getNumericValue(number.charAt(i));
            if( k > 0 && !stack.isEmpty() ) {
                while(k>0 && !stack.isEmpty() && stack.peek() < parseNumber) {
                    stack.pop();
                    k--;
                }
                stack.push(parseNumber);
            } else {
                stack.push(parseNumber);
            }            
        }
        if(k>0) {
            for(int i = 0; i<k; i++){
                stack.pop();
            }
        }
        for(int i: stack) {
            sb.append(Integer.valueOf(i));
        }
        return sb.toString();
    }
}