class Solution {
    // Time complexity : O(N);
    // Space Complexity: O(N)
    public boolean isIsomorphic(String s, String t) {
        // mapST stores the character of 's' as a key and character of 't' as a value
        HashMap<Character, Character> mapST = new HashMap<>();
        // mapTS is the reverse map of mapST
        HashMap<Character, Character> mapTS = new HashMap<>();

        //traverse the both string character by character
        for(int i = 0; i < s.length(); i++){
            char chS = s.charAt(i);  // current character of string 's'
            char chT = t.charAt(i); // current character of string 't'

            // in mapST contanis the chS
            if(mapST.containsKey(chS)){
                //if chS is exists then check the value of chS is equal to chT
                // if it is not equal then it is not isomorphic string
                if(mapST.get(chS) != chT){
                    return false;
                }
            }else{
                // if mapST not contains chS the put it into the mapST
                mapST.put(chS, chT);
            }

            // then check reverse mapping 't' as a key and 's' as a value
            if(mapTS.containsKey(chT)){
                if(mapTS.get(chT) != chS){
                    return false;
                }
            }else{
                mapTS.put(chT, chS);
            }
        }
        // if all charcter are isomorphic then return true
        return true;
    }
}