class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            String s = words[i];
            if(helper(s, x)){
                list.add(i);
            }
        }
        return list;
    }
    private static boolean helper(String s, char x){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==x){
                return true;
            }
        }
        return false;
    }
}