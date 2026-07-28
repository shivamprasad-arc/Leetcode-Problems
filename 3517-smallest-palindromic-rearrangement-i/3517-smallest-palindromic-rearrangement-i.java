class Solution {
    // Time Complexity : O(N log N)
    // Space Complexity: O(N)
    public String smallestPalindrome(String s) {
        if(s.length() == 1 || s.length() == 3) return s;
        // first convert the string to character array due to a string is immutable 
        char[] arr = s.toCharArray();
        int n = arr.length;
        int mid = n / 2;

        // Sort the half portion of the array
        if(n % 2 != 0){
            // in even length sort the characters from 0 to mid - 1
            Arrays.sort(arr, 0, mid);
        }else{
            // in odd length sort the characters from 0 to mid
            Arrays.sort(arr, 0,  mid);
        }

        // copy the characters of sorted left half into to right half
        int left = 0;
        int end = n - 1;
        while(left < end){
            arr[end] = arr[left];
            left++;
            end--;
        }

        // return the modified string into smallest lexicographical palindrome
        s = new String(arr);
        return s;
    }
}