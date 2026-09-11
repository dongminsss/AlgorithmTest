import java.util.*;

class Solution {
    int x;
    int y;
    String[] memberPark;
    public int[] solution(String[] park, String[] routes) {
        y = park.length;
        x = park[0].length();
        memberPark = park;
        int[] start = new int[2];
        for(int i = 0; i<y; i++) {
            for(int j = 0; j<x; j++) {
                if(park[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        for(String route : routes) {
            move(route, start);
            System.out.println(Arrays.toString(start));
        }
        
        
        return start;
    }
    
    public void move(String route, int[] start) {
        String[] part = route.split(" ");
        char dir = part[0].charAt(0);
        int dis = Integer.parseInt(part[1]);
        int dx = start[1];
        int dy = start[0];
        
        if(dir == 'E') dx += dis;
        if(dir == 'W') dx -= dis;
        if(dir == 'S') dy += dis;
        if(dir == 'N') dy -= dis;
        
        if(isRange(dx, dy) && isObstacle(dir, dis, start)) {
            start[0] = dy;
            start[1] = dx;
        }
    }
    
    public boolean isRange(int dx, int dy) {
        return dx >= 0 && dy >= 0 && dy < y && dx < x;
    }
    
    public boolean isObstacle(char dir, int dis, int[] start) {
        int startX = start[1];
        int startY = start[0];
        if(dir == 'E') {
            for(int i = startX; i <= startX + dis; i++) {
                if(memberPark[startY].charAt(i) == 'X') return false;
            }
        }
        
        if(dir == 'W') {
            for(int i = startX; i >= startX - dis; i--) {
                if(memberPark[startY].charAt(i) == 'X') return false;
            }
        }
        
        if(dir == 'S') {
            for(int i = startY; i <= startY + dis; i++) {
                if(memberPark[i].charAt(startX) == 'X') return false;
            }
        }
        
        if(dir == 'N') {
            for(int i = startY; i >= startY - dis; i--) {
                if(memberPark[i].charAt(startX) == 'X') return false;
            }
        }
        
        return true;
    }
}