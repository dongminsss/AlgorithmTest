import java.util.*;

class Solution {
    HashSet<Set<String>> result = new HashSet<>();
    Map<String, List<String>> table = new HashMap<>();
    int count = 0;
    public int solution(String[] user_id, String[] banned_id) {
        for(int i = 0; i<banned_id.length; i++) {
            List<String> list = new ArrayList<>();
            for(int j = 0; j<user_id.length; j++) {
                if(banIdMatch(banned_id[i] , user_id[j])) {
                    list.add(user_id[j]);
                }
            }
            table.put(banned_id[i], list);
        }
        // for(String key : table.keySet()) {
        //     List<String> strList = table.get(key);
        //     System.out.println(key + ": " + strList.toString());
        // }
        
        for(String str : table.get(banned_id[0])) {
            dfs(new HashSet<>(), banned_id, 0);
        }
        int answer = result.size();
        return answer;
    }
    
    private boolean banIdMatch(String standard, String compare) {
        if(standard.length() != compare.length()) return false;
        for(int i = 0; i<standard.length(); i++) {
            if(standard.charAt(i) == '*') {
                continue;
            } else {
                if(standard.charAt(i) != compare.charAt(i)) return false;
            }
        }
        return true;
    }
    
    private void dfs(Set<String> set, String[] banned_id, int depth) {
        if(banned_id.length == depth) {
            result.add(new HashSet<>(set));
            count++;
            return;
        }
        for(String str : table.get(banned_id[depth])) {
            if(!set.contains(str)) {
                set.add(str);
                dfs(set, banned_id, depth+1);
                set.remove(str);
            }
        }
        
    }
}