class Solution {
    static int count;
    static int staticTarget;
    static int[] arr;
    public int solution(int[] numbers, int target) {
        
        staticTarget = target;
        arr = numbers;
        dfs(arr[0], 1, 0);
        dfs(-arr[0], 1, 0);
        int answer = count;
        return answer;
    }
    public static void dfs(int a, int depth, int sum) {
        sum += a;
        if(depth == arr.length) {
            if(staticTarget == sum) count++;
            return;
        } else {
            dfs(-arr[depth], depth+1, sum);
            dfs(arr[depth], depth+1, sum);
        }
    }
}