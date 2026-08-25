class Solution {
    // Time complexity: O(N)
    // Space complexity: O(N)
    public int missingMultiple(int[] nums, int k) {
        // HashSet only stores the element which is multiple of k
        HashSet<Integer> multiple = new HashSet<>();
        for(int curr: nums){
            if(curr % k == 0){
                multiple.add(curr);
            }
        }
        
        int i = 1;
        // start checkin in HashSet for k, 2k, 3k, 4k,....
        while(true){
            int candidate = k * i;
            i++;
            // if not contain current candidate then return that missing element
            if(!multiple.contains(candidate)){
                return candidate;
            }
        }
    }
}