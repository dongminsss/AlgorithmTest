import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        String[][] map = makeMap(storage);
        
        for(String request : requests) {
            
            if(request.length() > 1) {
                request = String.valueOf(request.charAt(0));
                crane(map, request);
            } else {
                Set<int[]> set = bfs(map, new boolean[map.length][map[0].length], request);
                remove(map, set);
                
            }
            
        }
        
        return itemCount(map);
    }
    
    private String[][] makeMap(String[] storage) {
        int x = storage[0].length();
        int y = storage.length;
        String[][] map = new String[y+2][x+2];
        
        for(int i = 0; i<y; i++) {
            for(int j = 0; j<x; j++) {
                map[i+1][j+1] = String.valueOf(storage[i].charAt(j));
            }
        }
        return map;
    }
    
    private Set<int[]> bfs(String[][] map, boolean[][] visited, String target) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        Set<int[]> set = new HashSet<>();
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        dq.offer(new int[]{0,0});
        
        while(!dq.isEmpty()){
            int[] current = dq.poll();
            int x = current[0];
            int y = current[1];
            visited[y][x] = true;
            for(int i = 0; i<4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(isRange(nextX, nextY, map) && !visited[nextY][nextX]) {
                    if(map[nextY][nextX] == null) {
                        dq.offer(new int[]{nextX, nextY});
                        visited[nextY][nextX] = true;
                    }
                    if(target.equals(map[nextY][nextX])) {
                        set.add(new int[] {nextX, nextY});
                    } 
                }
            }
            
        }
        
        return set;
    }
    
    private boolean isRange(int x, int y, String[][] map) {
        return x >= 0 && y >= 0 && x<map[0].length && y < map.length;
    }
    
    private void crane(String[][] map, String target) {
        for(int i = 0; i<map.length; i++) {
            for(int j = 0; j<map[i].length; j++) {
                if(target.equals(map[i][j])) map[i][j] = null;
            }
        }
    }
    
    private void remove(String[][] map, Set<int[]> set) {
        for(int[] xy : set) {
            int x = xy[0];
            int y = xy[1];
            map[y][x] = null;
        }
    }
    private int itemCount(String[][] map) {
        int count = 0;
        for(String[] strs : map) {
            for(String str : strs) {
                if(str != null) count++;
            }
        }
        return count;
    }
}