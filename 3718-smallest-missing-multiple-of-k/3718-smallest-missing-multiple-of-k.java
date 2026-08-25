class Solution {
    // time complexity: O(N logN)
    // Space complexity: O(1)
    public int missingMultiple(int[] nums, int k) {
        int i = 0;  // counter to track how many multiple of k we've seen
        // sort the array to arrange the first multiple of k is in first
        Arrays.sort(nums);
        int prev = -1;  // track last seen multiple

        // traverse the array
        for(int x: nums){
            // if the current is completely divisible by x then
            if(x % k == 0 && prev != x) {
                i++;  // update the count of multiples found

                // Verify if the expected multiple (k * i) matches the current element
                // If not, that means k*i is missing in the array
                if(k * i != x){
                    return k*i;  // return the missing muliple
                }
                prev = x;
            }
        }
        return k*(++i);  // if no multiple found inside the loop, then the multiple after the last one is  missing
    }
}