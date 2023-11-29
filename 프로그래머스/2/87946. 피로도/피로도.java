class Solution {
    static int[][] staticDungeons;
    static int maxCount;

    public int solution(int k, int[][] dungeons) {
        staticDungeons = dungeons;
        maxCount = 0;
        
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, visited, 0);  // 시작점에서 count를 0으로 초기화
        
        return maxCount;
    }
    
    public static void dfs(int k, boolean[] visited, int count){
        maxCount = Math.max(maxCount, count);  // 방문할 때마다 maxCount를 업데이트
        
        for(int i = 0; i < staticDungeons.length; i++) {
            if(!visited[i] && staticDungeons[i][0] <= k) {
                visited[i] = true;
                dfs(k - staticDungeons[i][1], visited, count + 1);  // 다음 던전 방문
                visited[i] = false;  // 방문 상태를 되돌림
            }
        }
    }
}
