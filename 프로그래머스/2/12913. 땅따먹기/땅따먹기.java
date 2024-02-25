class Solution {
    public int solution(int[][] land) {
        // land 배열의 행 수만큼 메모이제이션 배열 초기화
        int[][] memo = new int[land.length][4];
        
        // 첫 번째 행은 바로 memo에 복사
        for(int i = 0; i < 4; i++) {
            memo[0][i] = land[0][i];
        }
        
        // 두 번째 행부터 각 행의 각 열에 대해 최대값 계산
        for(int i = 1; i < land.length; i++) {
            for(int j = 0; j < 4; j++) {
                int maxVal = 0;
                for(int k = 0; k < 4; k++) {
                    if(j != k) { // 이전 행에서 같은 열을 제외하고 최대값 탐색
                        maxVal = Math.max(maxVal, memo[i-1][k]);
                    }
                }
                memo[i][j] = land[i][j] + maxVal; // 현재 값에 최대값을 더해 메모이제이션
            }
        }
        
        // 마지막 행에서 최대값 찾기
        int answer = 0;
        for(int i = 0; i < 4; i++) {
            answer = Math.max(answer, memo[memo.length-1][i]);
        }
        
        return answer; // 최대 합 반환
    }
}
