class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];

            if ((num & 1) == 0) {
                answer[i] = num + 1;
            } else {
                long rightmostZero = (~num) & (num + 1);
                answer[i] = (num | rightmostZero) ^ (rightmostZero >> 1);
            }
        }
        return answer;
    }
}
