class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<String> list = new ArrayList<>();
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)!='1') i++;
            else break;
        }
        if(i==s.length()) return "";
        while(i<s.length()){
            int j=i;
            int count = 0;
            while(count!=k && j<s.length()){
                if(s.charAt(j)=='1') count++;
                j++;
            }
            if (count != k) break;
            list.add(s.substring(i,j));
            i++;
            while(i<s.length()){
                if(s.charAt(i)!='1') i++;
                else break;
            }
        }
        if(list.isEmpty()) return "";

        String ans = list.get(0);
        for (String str : list) {
            if (str.length() < ans.length()) {
                ans = str;
            }
            else if (str.length() == ans.length() && str.compareTo(ans) < 0) {
                ans = str;
            }
        }
        return ans;
    }
}