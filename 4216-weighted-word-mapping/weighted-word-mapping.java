class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();

        char[] arr1 = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<arr1.length;i++){
            map.put(arr1[i], i);
        }

        for(int i=0;i<words.length;i++){
            String s = words[i];
            int sum = 0;
            for(int j=0;j<s.length();j++){
                sum += weights[map.get(s.charAt(j))];
            }
            int num = (sum%26);
            char ch = arr1[25-num];
            result.append(ch);
        }
        return result.toString();
    }
}