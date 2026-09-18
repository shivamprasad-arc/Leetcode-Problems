class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // pointer starts from end index
        int i = m - 1;  // for last valid index of nums1
        int j = n - 1;   // for last index of nums2
        int k = m + n - 1;  // last position of entire nums1

        // merge the element in sorted for from right to left
        while(i >= 0 && j >= 0){
            if(nums1[i] >= nums2[j]){
                nums1[k] = nums1[i];
                k--;
                i--;
            }else{
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
        // If there are leftover elements in nums2, copy them.
        while(j >= 0){
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }
}