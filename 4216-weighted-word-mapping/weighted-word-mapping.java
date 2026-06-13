class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();

        char[] arr1 = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] arr2 = {'z','y','x','w','v','u','t','s','r','q','p','o','n','m','l','k','j','i','h','g','f','e','d','c','b','a'};

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<arr1.length;i++){
            map.put(arr1[i], i);
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i=0;i<arr2.length;i++){
            map2.put(arr2[i], i);
        }

        for(int i=0;i<words.length;i++){
            String s = words[i]; //abcd , def  , xyz
            int sum = 0;
            for(int j=0;j<s.length();j++){
                sum += weights[map.get(s.charAt(j))];
            }
            int num = (sum%26);
            char ch = arr2[num];
            result.append(ch);
        }
        return result.toString();
    }
}