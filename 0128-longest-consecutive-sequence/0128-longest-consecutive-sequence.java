class Solution {
    //Approach 1: 
    // Time complexity: O(N log N)
    // Space Complexity: O(1)
    public int longestConsecutive(int[] nums) {
        //Empty array has no sequence
        if(nums.length == 0) return 0;
        //sort the array to find longest consecutive easily
        Arrays.sort(nums);

        
        int longest = 1; // sotres maximum sequece
        int curr = 1;    //store current consecutive sequence
        // traverse array and find the longest consecutive elements sequence
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1]) continue;  // skip dulicates

            // if curr number is exact 1 smaller than current next number then we update the current
            if(nums[i] == nums[i + 1] - 1){
                curr++;
            }else{
                //sequence breaks here
                //update the longest and current
                longest = Math.max(longest, curr);
                curr = 1;
            }
        }
        return Math.max(longest, curr);
    }
}