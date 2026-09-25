class Solution {
    // Time Complexity: O(N)
    // Space complexity: O(N)
    // Two pointer approach
    public String reverseOnlyLetters(String s) {
        // convert string to char array 
        char arr[] = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while(i <= j){
            // if the left character is not letter then go to next character
            if(!Character.isLetter(arr[i])){
                i++;
            }
            // if the right character is not letter then go to next character
            else if(!Character.isLetter(arr[j])){
                j--;
            }
            // if both character are letter then swap the characters 
            else{
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}