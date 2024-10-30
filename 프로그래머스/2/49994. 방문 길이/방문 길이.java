import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Set<String> pathSet = new HashSet<>();
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        char[] dir = {'R','L','D','U'};
        
        int x = 0;
        int y = 0;
        
        for(char c : dirs.toCharArray()) {
            int index = 0;
            for(int i = 0; i<dir.length; i++) {
                if(dir[i] == c) {
                    index = i;
                    break;
                }
            }
            
            int nx = x + dx[index];
            int ny = y + dy[index];
            
            if(nx >= -5 && nx <= 5 && ny >= -5 && ny <=5) {
                String str1 = x + " " + y +"->" + nx+" "+ ny;
                String str2 = nx + " " + ny +"->" + x+" "+ y;
                if(!pathSet.contains(str1)) {
                    pathSet.add(str1);
                    pathSet.add(str2);
                }
                x = nx;
                y = ny;
            }
        }
        
        
        return pathSet.size()/2;
        
        
    }
}