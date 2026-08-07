class Solution {
    public int firstUniqueEven(int[] nums) {
        // HashMap stores only even number of nums array and their frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        // traverse the original array to maintain it's order
        // due to Return an integer denoting the first even integer (earliest by array index) that appears exactly once in nums
        for(int x: nums){
            // current element is even element and whose frequency is 1 then that even element is unique 
            if(x % 2 == 0 && map.get(x) == 1){
                return x;
            }
        }
        // if no any unique element is present then return -1
        return -1;
    }
}