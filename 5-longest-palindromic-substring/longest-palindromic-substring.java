class Solution {
    public String longestPalindrome(String s) {
        List<String> list = new ArrayList<>();
        List<Integer> lenList = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            StringBuilder sb = new StringBuilder();
            for(int j=s.length()-1;j>=0;j--){
                if(isPalindrome(s, i, j)){
                    sb.append(s.substring(i, j+1));
                    break;
                }
            }
            list.add(sb.toString());
        }
        for(int i=0;i<list.size();i++){
            String t = list.get(i);
            lenList.add(t.length());
        }
        Collections.sort(lenList);
        int maxLen = lenList.get(lenList.size()-1);
        for(int i=0;i<list.size();i++){
            String a = list.get(i);
            if(a.length()==maxLen){
                return a;
            }
        }
        return "";
    }
    private boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}