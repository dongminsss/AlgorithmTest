import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);
        
        for(int i = 1; i<strings.length; i++) {
        
            for(int j = i; j > 0; j--) {
                if(strings[j].charAt(n) < strings[j-1].charAt(n)) {
                    String temp = strings[j-1];
                    strings[j-1] = strings[j];
                    strings[j] = temp;
                }
            }
            
            
        }
        
        return strings;
    }
}