class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            list.add(words[i]);
        }

        List<String> uniq = helper(list);
        int count = 0;
        for(int i=0;i<uniq.size();i++){
            boolean flag = true;
            for(int j=0;j<uniq.get(i).length();j++){
                if(!allowed.contains("" + uniq.get(i).charAt(j))){
                    flag = false;
                    break;
                }
            }
            if(flag){
                count++;
            }
        }
        return count;
    }
    
    private static List<String> helper(List<String> list){
        List<String> uniq = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            String s = list.get(i);
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<s.length();j++){
                set.add(s.charAt(j));
            }
            String temp = "";
            for(char x : set){
                temp += x;
            }
            uniq.add(temp);
        }
        return uniq;
    }
}