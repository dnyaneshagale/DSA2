class Solution {
    public int search(int[] arr, int target) {
        
        int si = 0, ei = arr.length-1;

        while (si <= ei) {
            int mid = (si+ei)/2;

            if (arr[mid] == target) {
                return mid;
            }

            // Left Half is Sorted
            if (arr[si] <= arr[mid]) {

                // Search in the left half
                if (arr[si] <= target && target < arr[mid]) {
                    ei = mid - 1; 
                } else { // Search in the right half
                    si = mid + 1;
                }
            } 
            // Otherwise , Right half is sorted
            else {

                if (arr[mid] < target && target <= arr[ei]) {
                    si = mid + 1;  // Search in the right half
                } else {
                    ei = mid - 1;   // Search in the left half
                }
            }
        }
        return -1;
    }
}