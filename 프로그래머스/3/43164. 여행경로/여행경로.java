import java.util.*;

class Solution {
    
    private static boolean[] visited;
    private static List<String> list;

    public String[] solution(String[][] tickets) {
        int ticketsLength = tickets.length;
        list = new ArrayList<>();
        visited = new boolean[ticketsLength];
        
        dfs("ICN","ICN",0,tickets);
        
        list.sort(null);
        
        return list.get(0).split(" ");
    }
    
    private void dfs(String current, String path, int depth, String[][] tickets) {
        if(depth == tickets.length) {
            list.add(path);
            return;
        }
        
        for(int i = 0; i<tickets.length; i++) {
            if(!visited[i] && current.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1] , depth+1 , tickets);
                visited[i] = false;
            }
        }
    }
}