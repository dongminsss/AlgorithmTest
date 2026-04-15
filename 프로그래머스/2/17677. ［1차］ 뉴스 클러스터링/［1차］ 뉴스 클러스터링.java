import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        int[] numbers = jacad(makeSplit(str1), makeSplit(str2));
        
        if (numbers[1] == 0) return 65536;
        return (int)(65536 * (numbers[0] / (double)numbers[1]) );
    }
    
    private String[] makeSplit(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < str.length(); i++) {
            char a = str.charAt(i - 1);
            char b = str.charAt(i);
            if (Character.isLetter(a) && Character.isLetter(b)) {
                list.add("" + a + b);
            }
        }
        return list.toArray(new String[0]);
    }
    
    private int[] jacad(String[] arr1, String[] arr2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (String s : arr1) map1.put(s, map1.getOrDefault(s, 0) + 1);
        for (String s : arr2) map2.put(s, map2.getOrDefault(s, 0) + 1);

        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        int intersection = 0, union = 0;
        for (String key : keys) {
            int cnt1 = map1.getOrDefault(key, 0);
            int cnt2 = map2.getOrDefault(key, 0);
            intersection += Math.min(cnt1, cnt2);
            union += Math.max(cnt1, cnt2);        
        }
        return new int[]{intersection, union};
    }
}