class Solution {
    // Two pointer approach
    // TC: O(N)
    // SC: O(N)
    public String reverseVowels(String s) {
        // store the all characters of string into the character array
        // Because we can't reverse the character in string 
        char arr[] = s.toCharArray();
        int st = 0;
        int end = arr.length - 1;
        while(st < end){
            // if start is not vowel then go to the next character
            while(st < end && !isVowel(arr[st])){
                st++;
            }
            // if end is not vowel then go to the previous character
            while(st < end && !isVowel(arr[end])){
                end--;
            }

            // Reverse the vowel
            char temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
            st++;
            end--;
        }
        // return reversed string
        return new String(arr);
        
    }
    // chech the current character is vowel or not
    public static boolean isVowel(char ch){
        return (ch == 'a' || ch == 'A' || 
                ch == 'e' || ch == 'E' ||
                ch == 'i' || ch == 'I' ||
                ch == 'o' || ch == 'O' ||
                ch == 'u' || ch == 'U');
    } 
}