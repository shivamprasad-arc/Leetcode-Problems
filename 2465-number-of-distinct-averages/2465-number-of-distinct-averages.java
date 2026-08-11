class Solution {
    // time complexity: O(n log n)
    // space complexity: O(n/2)
    public int distinctAverages(int[] nums) {
        // sort the array to arrange the elements in increasing order for finding minimum and maximum numbers
        Arrays.sort(nums);
        // Set stores the number of distinct averages
        HashSet<Float> set = new HashSet<>();
        // using two pointers
        int i = 0, j =  nums.length - 1;
        while(i <= j){
            // find the average all smallest and largest elemnt
            float avg = (nums[i] + nums[j])/ 2.0f;
            set.add(avg);  // add the average to set
            // update i and j
            i++; 
            j--;
        }
        // return the number of distinct averages i.e., size of set
        return set.size();
    }
}