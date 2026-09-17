class Solution {
    // time complexity: O(N)
    // Space complexity: O(1)
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0; 
        int j = 0;
        int currSum = 0;
        int minSize = Integer.MAX_VALUE;
        for(j = 0; j < nums.length; j++){
            currSum += nums[j];
            while(currSum >= target){
                minSize = Math.min(minSize, j - i + 1);
                currSum -= nums[i++];
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}