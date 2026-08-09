class Solution {
    public int maxFreqSum(String s) {
        // vowelMap stores only vowel character and their frequency
        HashMap<Character, Integer> vowelMap = new HashMap<>();
        // consMap stores cosonant characters and their frequency
        HashMap<Character, Integer> consMap = new HashMap<>();

        // store vowel and consonant characters and thier frequencies
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                vowelMap.put(ch, vowelMap.getOrDefault(ch, 0) + 1);
            }else{
                consMap.put(ch, consMap.getOrDefault(ch, 0) + 1);
            }
        }


        int vowelMax = 0;  // max frequency of vowel character
        int constMax = 0;   // max frequency of consonant character

        // traverse the vowelMap and find vowelMax
        for(char ch: vowelMap.keySet()){
            if(vowelMax < vowelMap.get(ch)){
                vowelMax = vowelMap.get(ch);
            }
        }

        //traverse the consMap and find constMax
        for(char ch: consMap.keySet()){
            if(constMax < consMap.get(ch)){
                constMax = consMap.get(ch);
            }
        }

        // return the sum of most frequent vowel and consonant
        return vowelMax + constMax;
    }
}