class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='-') sb.append(s.charAt(i));
        }
        s = sb.toString().toUpperCase();
        StringBuilder res = new StringBuilder();
        int idx = 0;
        for(int i=s.length()-1;i>=0;i--){
            res.append(s.charAt(i));
            idx++;
            if(idx%k==0) res.append('-');
        }
        if(res.length()==0) return "";
        if(res.charAt(res.length()-1)=='-') res.deleteCharAt(res.length()-1);
        return res.reverse().toString();
    }
}