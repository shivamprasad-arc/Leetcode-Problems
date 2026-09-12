class Solution {
    // Time complexity: O(N)
    // Space complexity: O(N)
    public int[] frequencySort(int[] nums) {
        // store frequency of each number
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // min heap sort the number according to their frequency
        // if two number has same frequency then largest number come first 
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> { 
                // lower frequency comes first
                if(a.getValue() != b.getValue()){
                    return a.getValue() - b.getValue();
                }
                // same frequency - largest number comes first
                return b.getKey() - a.getKey();
            }
        );

        // add all element to the min heap
        pq.addAll(map.entrySet());
        
        int i = 0;
        // take elements according to their priority
        while(!pq.isEmpty()){
            Map.Entry<Integer, Integer> key = pq.remove();
            int freq = key.getValue();

            // put the number into the nums array 'freq' times
            while(freq > 0){
                nums[i++] = key.getKey();
                freq--;
            }
        }
        return nums;
    }
}