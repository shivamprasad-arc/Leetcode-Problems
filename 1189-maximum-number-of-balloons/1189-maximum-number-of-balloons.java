class Solution {
    public int maxNumberOfBalloons(String text) {
        // HashMap store the character and their frequency of only required characters.
        Map<Character, Integer> map = new HashMap<>();

        // add required characters(b, a, l, o, n) and their frequency to the map
        for(int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);
            if(ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n'){
                map.put(ch, map.getOrDefault(ch, 0)+1);
            }
        }

        // Get frequency of each characters
        int b = map.getOrDefault('b', 0);
        int a = map.getOrDefault('a', 0);
        // here divided by 2 due to 'l' and '0' repeated 2 times in the word "balloon"
        int l = map.getOrDefault('l', 0) / 2;  
        int o = map.getOrDefault('o', 0) / 2;
        int n = map.getOrDefault('n', 0);

        // Return the maximum number of balloon formed 
        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
}