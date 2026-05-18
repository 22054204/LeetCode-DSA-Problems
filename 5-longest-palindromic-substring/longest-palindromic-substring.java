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
        int maxLen = maxLen(lenList);
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
    private static int maxLen(List<Integer> list){
        if(list.size()==0) return 0;
        int max = list.get(0);
        for(int i=1;i<list.size();i++){
            if(list.get(i)>max){
                max = list.get(i);
            }
        }
        return max;
    }
}