class Solution {
    // Time Complexity: O(N)
    // Space complexity: O(1)
    public int minimumDeletions(int[] nums) {
        int minIdx = 0; // store the index of minimum element
        int maxIdx = 0; // store the index of maximum element
        // traverse the array and find index of min and max element
        for(int i = 0; i < nums.length; i++){
            if(nums[minIdx] > nums[i]){
                minIdx = i;
            }
            if(nums[maxIdx] < nums[i]){
                maxIdx = i;
            }
        }
        /*
         * CASE 1:
         * Remove elements from BOTH sides.
         * Suppose min and max are at indices minIdx and maxIdx.
         * We remove the smaller index from the left and the larger index from the right.
         * Example:
         * [min, ......., max]
         *  ^             ^
         * left           right
         * left deletions  = min(minIdx, maxIdx) + 1
         * right deletions = nums.length - max(minIdx, maxIdx)
         */
        int left = Math.min(minIdx, maxIdx) + 1;
        int right = nums.length - Math.max(minIdx, maxIdx);


        /*
         * CASE 2:
         * Remove BOTH minimum and maximum from the LEFT.
         * We have to delete everything up to the element which is farther from the left.
         *
         * Example:
         * [ ... min ... max ... ]
         *           ^
         *      farther index
         * Deletions = max(minIdx, maxIdx) + 1
         */
        int bothLeft = Math.max(minIdx, maxIdx) + 1;

        /*
         * CASE 3:
         * Remove BOTH minimum and maximum from the RIGHT.
         * We have to delete everything from the right up to the element which is closer to the left.
         * Deletions = nums.length - min(minIdx, maxIdx)
         */
        int bothRight = nums.length - Math.min(minIdx, maxIdx);

        /*
         * We have three possible strategies:
         * 1. Delete from both sides -> left + right
         * 2. Delete both from left -> bothLeft
         * 3. Delete both from right -> bothRight
         * Take the minimum among all three.
         */
        return Math.min(bothLeft, Math.min(bothRight, left + right));
    }
}