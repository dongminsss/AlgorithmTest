import java.util.*;

public class Solution {
    public Integer[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<arr.length; i++) {
            if(i == 0) stack.push(arr[i]);
            if(stack.peek() != arr[i]) stack.push(arr[i]);  
        }
        
        Integer[] answer = stack.toArray(new Integer[0]);
        
        return answer;
    }
}