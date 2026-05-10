class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        String s = "";
        for(int i = 0; i < chunks.length; i++){
            s += chunks[i];
        }
        int n = queries.length;
        ArrayList<String> list = new ArrayList<>();
        String temp = "";
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                temp += ch;
            }
            else if(ch == '-'){
                if(i > 0 && i < s.length() - 1 &&
                   s.charAt(i - 1) >= 'a' && s.charAt(i - 1) <= 'z' &&
                   s.charAt(i + 1) >= 'a' && s.charAt(i + 1) <= 'z'){
                    temp += ch;
                }
                else{
                    if(temp.length() > 0){
                        list.add(temp);
                        temp = "";
                    }
                }
            }
            else{
                if(temp.length() > 0){
                    list.add(temp);
                    temp = "";
                }
            }
        }
        if(temp.length() > 0){
            list.add(temp);
        }
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            String word = list.get(i);
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            result[i] = map.getOrDefault(queries[i], 0);
        }
        return result;
    }
}