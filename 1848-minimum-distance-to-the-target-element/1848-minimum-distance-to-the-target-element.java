class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int minDist = Integer.MAX_VALUE;  // it tracks the minimum distance from start to target

        // iterate the array and find minimum distance
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                // if target is found then calculate the absolute of difference of current index and starting index
                // then find the minimum of minDist and absolute value that is updated value of minDist
                minDist = Math.min(minDist, Math.abs(i - start));
            }
        }
        // return the minDist
        return minDist;
    }
}