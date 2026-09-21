class Solution {
    // time complexity:O(n! * n)
    // space complexity: O(n)
    public List<List<Integer>> permute(int[] nums) {
        // ans stores the answer
        List<List<Integer>> ans = new ArrayList<>();
        // list stores the current permutation
        List<Integer> list = new ArrayList<>();

        // freq checks freq[i] tells us whether nums[i] has already been used in the current permutation or not
        boolean freq[] = new boolean[nums.length];

        // permutation generating using recursion
        recurPermute(nums, list, ans, freq);
        return ans;
    }
    public static void recurPermute(int[] nums, List<Integer> list, List<List<Integer>> ans, boolean[] freq){
        // BASE CASE:
        // If the current list contains the same number of elements as nums, we have created one complete permutation.
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));  // add current permutation list to the answer list 
            return;
        }

         // Try every element of nums at the current position
        for(int i = 0; i < nums.length; i++){

             // If this element has NOT been used yet,
            if(!freq[i]){
                // Mark nums[i] as used.
                freq[i] = true;
                list.add(nums[i]); // Add nums[i] to the current permutation.
                recurPermute(nums, list, ans, freq); // Recursively try to fill the next position.

                 // ---------------- BACKTRACKING ----------------
                // Remove the last element that we added.
                
                // This allows us to try another choice for the current position.
                list.remove(list.size() - 1);

                // Mark nums[i] as unused again.
                
                // Now nums[i] can be used in another position of the permutation.
                freq[i] = false;
            }
        }
    }
}