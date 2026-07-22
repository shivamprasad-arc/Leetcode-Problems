class Solution {
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int sumOfUnique(int[] nums) {
        // Map stores the value and their frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int sum = 0;
        // Iterate the map and whose frequency is equal to one the add the value else skip that value
        for(Integer value: map.keySet()){
            if(map.get(value) == 1){
                sum += value;
            }
        }
        // return the sum of unique elements
        return sum;
    }
}