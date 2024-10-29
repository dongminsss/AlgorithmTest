import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] numbersArr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        
        Arrays.sort(numbersArr, (a , b) -> (b + a).compareTo(a+b));
        if(numbersArr[0].equals("0")) {
            return "0";
        }
        return String.join("",numbersArr);
    }
}