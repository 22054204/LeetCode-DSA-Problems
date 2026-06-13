class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String s = "";
        
        HashMap<Character, Integer> map = new HashMap<>();
        char ch = 'a';
        for(int i=0;i<26;i++){
            map.put(ch, i);
            ch++;
        }

        for(int i=0;i<words.length;i++){
            int sum = 0;
            for(int j=0;j<words[i].length();j++){
                sum += weights[map.get(words[i].charAt(j))];
            }
            s += (char)('z'-(sum%26));
        }
        return s;
    }
}