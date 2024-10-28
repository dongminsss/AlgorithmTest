import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<String> list = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        for(int i = 'A'; i <= 'Z'; i++ ) {
            list.add(Character.toString(i));
        }
        
        char[] msgArr = msg.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < msgArr.length; i++) {
            sb.append(Character.toString(msgArr[i]));
            String str = sb.toString();
            if(list.indexOf(str) == -1) {
                list.add(str);
                String front = sb.substring(0, sb.length()-1);
                answer.add(list.indexOf(front) + 1);
                sb.delete(0,sb.length()-1);
            }
            
            if(i == msgArr.length -1) {
                answer.add(list.indexOf(sb.toString()) + 1);
            }
        }
        
        int[] result = answer.stream().mapToInt(Integer::intValue).toArray();
        
        return result;
    }
}