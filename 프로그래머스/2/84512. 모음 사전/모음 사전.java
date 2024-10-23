import java.util.*;
class Solution {
    static List<String> list = new ArrayList<>();
    static char[] words = {'A','E','I','O','U'};
    public int solution(String word) {
        
        
        generateWord("");
        list.sort(null);
        
        int answer = list.indexOf(word);
        return answer;
    }
    
    private static void generateWord(String word) {
        if(word.length() > 5) return;
        
        list.add(word);
        
        for(char c : words) {
            generateWord(word + c);
        }
    }
}