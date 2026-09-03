class Solution {
    // Optimized solution
    public int[] separateDigits(int[] nums) {
        // step 1: count the total digits in the nums array i.e, [13, 25, 83, 142] => digits = 9
        int digits = 0;
        // traverse the array and count the digits
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            while(n != 0){
                n /= 10;
                digits++;
            }
        }

        // step2: create a answer array of the size equal to no of digits present in the array
        int ans[] = new int[digits];
        int idx = digits - 1;  // // Start filling the answer array from the last index.

        // step 3: raverse nums from right to left.
        // We do this because digits are extracted from right to left.(Reversed order)
        for(int i = nums.length - 1; i >= 0; i--){
            int n = nums[i];
        
            while(n != 0){
                ans[idx--] = n % 10;
                n /= 10;
            }
        }
        // return the separated digits array
        return ans;
    }
}