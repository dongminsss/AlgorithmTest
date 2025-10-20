import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> list = colaList(k);
        double[] areas = new double[list.size() -1];
        for(int i = 0; i<areas.length; i++){
            areas[i] = (list.get(i) + list.get(i+1)) / 2.0;
        }
        
        double[] prefixSum = new double[list.size()];
        prefixSum[0] = 0.0;
        for(int i = 0; i<prefixSum.length-1; i++) {
            prefixSum[i+1] = (prefixSum[i] + areas[i]);
        }
        int i = 0;
        for(int[] arr : ranges) {
            int start = arr[0];
            int end = (list.size() - 1) + arr[1];
            
            if(start > end) {
                answer[i++] = -1.0;
            } else {
                answer[i++] = (prefixSum[end] - prefixSum[start]);
            }
        }
        
        
        return answer;
    }
    
    private List<Integer> colaList(int k) {
        List<Integer> result = new ArrayList<>();
        int count = 0;
        result.add(k);
        while(k > 1) {
            if(k % 2 == 0) {
                k /= 2;
            } else {
                k = (k * 3 + 1);
            }
            result.add(k);
            // System.out.println(k);
        }
        return result;
    }
}