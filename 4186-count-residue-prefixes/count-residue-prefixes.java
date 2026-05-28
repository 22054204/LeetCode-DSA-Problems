class Solution {
    public int residuePrefixes(String s) {
        int result = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
            if(set.size()==(i+1)%3){
                result++;
            }
            if(set.size()>2){
                break;
            }
        }
        return result;
    }
}