class Solution {
    public boolean rotateString(String s, String goal) {
        // if the length of  both string are unequal then return false 
        if(s.length() != goal.length()) return false;
        // create a newStr and add the string two times 
        // ex: s = abcde,  newStr = abcdeabcde
        String newStr = s + s;
        // now check if goal is the substring of newStr or not 
        // here 'cdeab' is the substring of newStr ab'cdeab'cde
        if(newStr.contains(goal)){
            return true;
        }
        return false;
    }
}