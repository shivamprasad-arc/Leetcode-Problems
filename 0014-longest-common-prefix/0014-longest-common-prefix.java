class Solution {
    // Time complexity: O(m X n)
    // Space complexity: P(m)
    public String longestCommonPrefix(String[] strs) {
        // base case: if string is null or empty then return empty string
        if(strs == null && strs.length == 0) return "";

        // list stores the commont prefix characters of the strings
        ArrayList<Character> list = new ArrayList<>();

        // add all the characters of first string into the list
        for(int i = 0; i < strs[0].length(); i++){
            char ch = strs[0].charAt(i);
            list.add(ch);
        }

        // compare the current prefix with remaining strings 
        for(int i = 1; i < strs.length; i++){
            int j = 0;
            // compare the string until the prefix mismatch or one string ends
            while(j < list.size() && j < strs[i].length()){
                char ch = strs[i].charAt(j);
                
                // if the current character is not matched then remove all remaining characters from the prefix list
                if(ch != list.get(j)){
                    list.subList(j, list.size()).clear();
                    break;
                }
                j++;   // update j
            }

            // if the current string is shoter then remove the extra characters
            // ex: list -> flower
            //     strs -> flow         it is shorter so we remove 'er' extra character from list
            if(j < list.size()){
                list.subList(j, list.size()).clear();
            }
        }

        // store the prefix character into ans and return
        String ans = "";
        for(int i = 0; i < list.size(); i++){
            ans += list.get(i);
        }
        return ans;
    }
}