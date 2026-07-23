class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int idx = 0;
        boolean onlyHyp = false;
        while(idx<s.length()){
            if(s.charAt(idx)=='-'){
                onlyHyp = true;
            }
            else {
                onlyHyp = false;
                break;
            }
            idx++;
        }
        if(onlyHyp) return "";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='-') sb.append(s.charAt(i));
        }
        sb.reverse();
        s = sb.toString().toUpperCase();
        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(i%k==0) res.append('-');
            res.append(s.charAt(i));
        }
        res.deleteCharAt(0);
        return res.reverse().toString();
    }
}