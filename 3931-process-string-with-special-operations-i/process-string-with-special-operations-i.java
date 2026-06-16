class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                sb.append(s.charAt(i));
            }else if(s.charAt(i)=='*'){
                if(!sb.isEmpty()){
                    sb.deleteCharAt(sb.length()-1);
                }else{
                    continue;
                }
            }
            else if(s.charAt(i)=='#'){
                sb.append(sb.toString());
            }
            else{
                sb.reverse();
            }
        }
        return sb.toString();
    }
}