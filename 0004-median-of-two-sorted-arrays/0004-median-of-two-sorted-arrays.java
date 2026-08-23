class Solution {
    // Time complexity: O(m + n)
    // Space complexity: O(m + n)
    // Two pointer approach
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // total number of elements in both arrays
        int n = nums1.length + nums2.length;

        // nums array store the merged sorted array
        int nums[] = new int[n];
        
        // i for pointer nums1, j for pointer nums2
        int i = 0, j = 0;
        int k = 0; // k for pointer nums

        // compare elements of both arrays and put smaller element in nums array
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                nums[k] = nums1[i];
                i++;
            }else{
                nums[k] = nums2[j];
                j++;
            }
            k++;
        }

        // if some elements is left in nums1 then copy all elements to the end of the array nums
        while(i < nums1.length){
            nums[k++] = nums1[i++];
        }

        // if some elements is left in nums2 then copy all elements to the end of the array nums
        while(j < nums2.length){
            nums[k++] = nums2[j++];
        }

        double ans = 0;

        // if total number of element is ODD then the median of the nums array is middle element
        if(n % 2 != 0){
            ans = nums[(n / 2)];
        }
        // if total number of element is EVEN then the median of the nums array is the average of two middle elements
        else{
            ans = (nums[n / 2] + nums[(n / 2) - 1]) / 2.0;
        }
        
        return ans;
    }
}