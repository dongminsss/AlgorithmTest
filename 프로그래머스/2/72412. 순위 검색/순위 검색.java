import java.util.*;

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        for(String str : info) {
            String[] arr = str.split(" ");
            makeCase(0, "", arr);
        }
        
        for(List<Integer> list : map.values()) {
            list.sort(null);
        }
        
        int[] answer = new int[query.length];
        
        for(int i = 0; i<query.length; i++) {
            String q = query[i].replace(" and ", " ");
            String[] arr = q.split(" ");
            String key = arr[0] + arr[1] + arr[2] + arr[3];
            int score = Integer.parseInt(arr[4]);
            
            if(!map.containsKey(key)) {
                answer[i] = 0;
                continue;
            }
            List<Integer> list = map.get(key);
            int idx = lowerBound(list, score);
            answer[i] = list.size() - idx;
        }
        return answer;
    }
    
    void makeCase(int depth, String key, String[] arr){
        if(depth == 4) {
            int score = Integer.parseInt(arr[4]);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            return;
        }
        makeCase(depth + 1, key + arr[depth], arr);
        makeCase(depth + 1, key + "-", arr);
    }
    
    int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        
        while(left < right) {
            int mid = (left + right) / 2;
            if(list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}