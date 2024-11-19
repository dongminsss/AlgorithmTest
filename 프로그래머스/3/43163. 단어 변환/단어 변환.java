import java.util.*;

class Solution {
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        if(min == Integer.MAX_VALUE) return 0;
       
        return min;
    }
    
    private static void dfs(String start, String mark, String[] words, int depth) {
    if(start.equals(mark)) {
        
        min = Math.min(min, depth);
        return;
    }
    if(depth == words.length) return;
    for(int i = 0; i<words.length; i++) {
        String word = words[i];
        int count = 0;
        for(int j = 0; j<word.length(); j++) {
            if(word.charAt(j) != start.charAt(j)) count++;
        }
        if(count == 1 && !visited[i]) {
            visited[i] = true;
            dfs(word, mark, words, depth+1);
            visited[i] =false;
        }
    }
    }
}