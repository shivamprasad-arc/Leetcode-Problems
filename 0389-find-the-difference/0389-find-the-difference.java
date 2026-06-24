class Solution {
    public char findTheDifference(String s, String t) {
        // HashMap stores the character and their frequency:
        // map sotres the characters and frequency of 't' string
        // map reduce their frequency of that characters which is present in 's' string.
        HashMap<Character, Integer> map = new HashMap<>();

        // stores the character and their frequency of 't' string
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }

        // reduce the frequncy of already present element in map
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.get(ch) - 1);
            if(map.get(ch) == 0){
                map.remove(ch);
            }
        }
        // return the rest one character of the map which is difference of both strings
        return map.keySet().iterator().next();
        }
}