class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        // Treemap stores the all elements of  the array with their frequency in sorted sequence
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(min > nums[i]){
                min = nums[i];
            }
        }

        // freq stores the freqency of first element
        int Firstfreq = map.get(min);
        // traverse the hashmap and find different frequency from the first element's frequency
        for(int x: map.keySet()){
            // if the freqency of first element is different from the frequency of current element 
            if(Firstfreq != map.get(x)){
                //  then return the first elemetn and current elemnt
                return new int[]{min, x};
            }
        }
        // if different frequency is not found then return -1, -1
        return new int[]{-1, -1};
    }
}