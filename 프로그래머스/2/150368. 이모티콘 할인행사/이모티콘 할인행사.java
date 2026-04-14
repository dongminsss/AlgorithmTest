import java.util.*;

class Solution {
    private static int[] e;
    private static int[][] u;
    private static ArrayList<int[]> list = new ArrayList<>();
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] discounts = new int[emoticons.length];
        e = emoticons;
        u = users;
        dfs(0, discounts);
        list.sort((o1,o2) -> {
            if(o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o2[0] - o1[0];
            }
        });
        
        return list.get(0);
    }
    
    private void dfs(int depth, int[] discountRates) {
        if(depth == e.length) {
            calculate(discountRates);
            return;
        }
        
        for(int rate : new int[]{10,20,30,40}) {
            discountRates[depth] = rate;
            dfs(depth + 1, discountRates);
        }
    }
    
    private void calculate(int[] discountRates) {
        int total = 0;
        int plusCount = 0;
        // System.out.println(Arrays.toString(discountRates));
        for(int i = 0; i<u.length; i++) {
            int userCoin = 0;
            for(int j = 0; j<discountRates.length; j++) {
                if(u[i][0] <= discountRates[j]) userCoin += (int)(e[j] * (100 - discountRates[j])) / 100;
            }
            if(u[i][1] > userCoin) {
                total += userCoin;
            } else {
                plusCount++;
            }
        }
        list.add(new int[]{plusCount, total});
    }
}