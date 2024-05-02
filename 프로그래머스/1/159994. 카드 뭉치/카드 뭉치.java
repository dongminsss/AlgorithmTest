class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int cardIndexOne = 0;
        int cardIndexTwo = 0;
        int goalIndex = 0;
        while(goalIndex < goal.length) {   
            if(cardIndexOne < cards1.length &&goal[goalIndex].equals(cards1[cardIndexOne])) {
                cardIndexOne++;
            } else if(cardIndexTwo < cards2.length && goal[goalIndex].equals(cards2[cardIndexTwo])) {
                cardIndexTwo++;
            } else {
                answer = "No";
                break;
            }
            goalIndex++;
        }
        return answer;
    }
}