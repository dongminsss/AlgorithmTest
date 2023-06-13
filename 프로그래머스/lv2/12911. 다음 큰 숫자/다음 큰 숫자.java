class Solution {
    public int solution(int n) {
        int answer = n+1;
        int countN = 0;
        int countOne = 0;
        while(n>0) {
            if(n%2 == 1) countN++;
            n/=2;
        }
        //System.out.print(countN);
        while(countN != countOne){
            int p = answer++;
            countOne = 0;
            while(p>0){
                if(p%2 == 1) countOne++;
                p/=2;
            }
        }
        return answer-1;
    }
}