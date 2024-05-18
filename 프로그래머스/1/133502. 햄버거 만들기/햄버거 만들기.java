import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        if(ingredient.length > 3) {
            for(int i = 0; i<ingredient.length; i++) {
                stack.push(ingredient[i]);
                if(stack.size() < 4) {
                    continue;
                } else {
                    int one = stack.elementAt(stack.size() - 4);
                    int two = stack.elementAt(stack.size() - 3);
                    int three = stack.elementAt(stack.size() - 2);
                    int four = stack.elementAt(stack.size() - 1);
                    
                    if(one == 1 && two == 2 && three == 3 && four == 1) {
                        answer++;
                        stack.pop();
                        stack.pop();
                        stack.pop();
                        stack.pop();
                    }
                    
                }
                
            } 
        }
        
        return answer;
    }
}