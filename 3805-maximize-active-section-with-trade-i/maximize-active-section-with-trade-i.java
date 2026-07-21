class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones_count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') ones_count++;
        }
        s = "1" + s + "1";
        List<Character> ch = new ArrayList<>();
        List<Integer> len = new ArrayList<>();
        int i=0;
        while (i<s.length()) {
            char c = s.charAt(i);
            int j=i;
            while (j<s.length() && s.charAt(j)==c) {
                j++;
            }
            ch.add(c);
            len.add(j-i);
            i=j;
        }
        // System.out.println(ch);
        // System.out.println(len);
        int ans = ones_count;
        for(i=1;i<ch.size()-1;i++){
            if(ch.get(i)=='1' && ch.get(i-1)=='0' && ch.get(i+1)=='0'){
                ans = Math.max(ans, ones_count+len.get(i-1)+len.get(i+1));
            }
        }
        return ans;
    }
}