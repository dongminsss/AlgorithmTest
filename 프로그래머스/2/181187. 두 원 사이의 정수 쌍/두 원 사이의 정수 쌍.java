class Solution {
    public long solution(int r1, int r2) {
        
        return circleInDotCount(r2) - innerCircleDotCount(r1);
    }
    
    long circleInDotCount(int r) {
        long count = 0;
        for (long i = 1; i <= r; i++) {
            long x = (long)r * r - i * i;
            x = (long)Math.sqrt(x);
            count += x * 2 + 1;
        }
        count = count * 2 + (long)r * 2 + 1;
        return count;
    }
    
    long innerCircleDotCount(int r) {
        long count = 0;
        for (long i = 1; i < r; i++) {
            long x2 = (long)r * r - i * i;
            long x = (long)Math.sqrt(x2);

            if (x * x == x2) x--;

            count += x * 2 + 1;
        }
        count = count * 2 + (r - 1) * 2 + 1;
        return count;
    }
}