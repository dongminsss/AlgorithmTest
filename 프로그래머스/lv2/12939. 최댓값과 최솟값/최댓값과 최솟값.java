import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strNumber=s.split(" ");
        System.out.println(Arrays.toString(strNumber));
        int[] number = new int[strNumber.length];
        for(int i = 0; i<strNumber.length; i++){
            number[i] = Integer.parseInt(strNumber[i]);
        }
        Arrays.sort(number);
        answer = number[0] + " " + number[number.length-1];
        return answer;
    }
}