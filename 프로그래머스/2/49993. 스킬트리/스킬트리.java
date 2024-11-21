import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String skill_tree : skill_trees) {
            List<Character> list = new ArrayList<>();
            
            for(char c : skill_tree.toCharArray()) {
                if(skill.indexOf(c) != -1) list.add(c);
            }
            boolean flag = true;
            for(int i = 0; i<list.size(); i++) {
                 if(list.get(i) != skill.charAt(i)) flag = false;    
            }
            
            if(flag) answer++;
        }
        return answer;
    }
}