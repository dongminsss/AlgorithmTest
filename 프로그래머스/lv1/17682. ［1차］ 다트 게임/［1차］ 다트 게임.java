import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String modify = "";
        int number = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<dartResult.length(); i++){
            if(dartResult.charAt(i) == 'S') {
                number = Integer.parseInt(modify);
                list.add(number);
                modify ="";
            } else if(dartResult.charAt(i) == 'D') {
                number = Integer.parseInt(modify);
                number = number * number;
                list.add(number);
                modify ="";
            } else if(dartResult.charAt(i) == 'T') {
                number = Integer.parseInt(modify);
                number = number * number * number;
                list.add(number); 
                modify ="";
            } else if(dartResult.charAt(i) == '*') {
                list.set(list.size()-1, list.get(list.size()-1)*2);
                if(list.size() > 1) list.set(list.size()-2, list.get(list.size()-2)*2);
            } else if(dartResult.charAt(i) == '#') {
                list.set(list.size()-1, list.get(list.size()-1)*-1);
            } else {
                modify += Character.toString(dartResult.charAt(i));
            }
        }
        for(Integer i : list) {
            answer += i;
        }
        return answer;
    }
    
}