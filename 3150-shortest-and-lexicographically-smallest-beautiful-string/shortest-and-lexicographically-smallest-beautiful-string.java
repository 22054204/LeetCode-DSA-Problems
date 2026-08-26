class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String result = "";
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)!='1') i++;
            else break;
        }
        if(i==s.length()) return "";
        while(i<s.length()){
            String temp = "";
            int j=i;
            int count = 0;
            while(count!=k && j<s.length()){
                if(s.charAt(j)=='1') count++;
                j++;
            }
            if (count != k) break;
            temp += s.substring(i,j);
            if (result.equals("") || temp.length() < result.length()) {
                result = temp;
            }
            else if (temp.length() == result.length() && temp.compareTo(result) < 0) {
                result = temp;
            }
            i++;
            while(i<s.length()){
                if(s.charAt(i)!='1') i++;
                else break;
            }
        }
        return result;
    }
}