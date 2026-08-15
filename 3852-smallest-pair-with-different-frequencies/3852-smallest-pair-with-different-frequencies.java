class Solution {
    // time complexity O(N)
    // space complexity O(N)
    public int[] minDistinctFreqPair(int[] nums) {
        // HashMap stores the frequency of all elements with their frequencies of array
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE; // min tracks the smallest element of the array
        // traverse the array and put their frequencies to the map and find smallest element
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(num < min){
                min = num;
            }
        }
        // firstFreq stores the frequency of the smallest element
        int firstFreq = map.get(min);
        int nextMin = Integer.MAX_VALUE;  // next min tracks the next smallest element
        // traverse the map and find next smallest element with different frequency
        for(int x: map.keySet()){

            // if the frequency of smallest element is not equal to the frequency of current element 
            // then find next smallest element
            if(firstFreq != map.get(x)){
                if(nextMin > x){
                    nextMin = x;
                }
            }
        }
        // if next smallest element with different frequency is not found then return {-1, -1}
        if(nextMin == Integer.MAX_VALUE){
            return new int[]{-1, -1};
        }
        // if nextMin with different frequency is found then return min and nextMin
        return new int[]{min, nextMin};
    }
}