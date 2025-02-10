public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {
        int n = A.length;
        
        int repeated = 0;
        int missing = 0;
        
        long expectedSum = 0;
        long actualSum = 0;
        
        for (int i = 0; i < A.length; i++) {
            expectedSum += i + 1;
            actualSum += A[i];
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < A.length; i++) {
            
            if (set.contains(A[i])) {
                repeated = A[i];
            } else {
                set.add(A[i]);
            }
        }
        
        missing = (int)(expectedSum - (actualSum - repeated));
        
        return new int[]{repeated, missing};
    }
}
