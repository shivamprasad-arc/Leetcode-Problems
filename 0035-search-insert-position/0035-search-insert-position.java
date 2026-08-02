class Solution {
    //Time complexity : O(log n)
    // space complexity: O(1)
    public int searchInsert(int[] nums, int target) {
        int st = 0;
        int end = nums.length - 1;
        // perform binary search approach
        while(st <= end){
            int mid = st + (end - st) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                st = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        // if target is not found then 'st' points to correct insertion position
        return st;
    }
}