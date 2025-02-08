class Solution {
    public void nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length;

        // Step 1 ; Find the Drop from the Ending idx
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                idx = i;
                break;
            }
        }

        /* 
            If no drop exist then just reverse the array
            since it's an edge case where it resets to 1st permutation
        */

        if (idx == -1) {
            reverse(nums, 0, n-1);
            return;
        }

        // Step 2 : Swap the drop element from ''Just Bigger'' element than the nums[idx]
        for (int i = n-1; i >= idx; i--) {
            if (nums[i] > nums[idx]) {
                swap(nums, i, idx);
                break;
            }
        }

        // Step 3 : Sort the Other Part, Since it's already sorted, Then just reverse it.
        reverse(nums, idx+1, n-1);
    }

    public void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }

    public void reverse(int[] nums, int si, int ei) {
        int n = nums.length;

        while(si <= ei) {
            swap(nums, si, ei);
            ei--;
            si++;
        }
    }
}