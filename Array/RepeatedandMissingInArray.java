class RepeatedandMissingInArray {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {
        int n = A.length;
        
        long expectedSum = (long) n * (n + 1) / 2; // Expected sum of numbers from 1 to N
        long expectedSumSq = (long) n * (n + 1) * (2 * n + 1) / 6; // Expected sum of squares
        
        long actualSum = 0, actualSumSq = 0;
        
        for (int num : A) {
            actualSum += num;
            actualSumSq += (long) num * num;
        }
        
        long x = actualSum - expectedSum;       // repeated - missing
        long y = actualSumSq - expectedSumSq;   // repeated^2 - missing^2
        
        long sum = y / x;  // (repeated + missing)
        
        int repeated = (int) ((x + sum) / 2);
        int missing = (int) repeated- (int)x;
        
        return new int[]{repeated, missing};
    }
}