class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                sb.append(ch);
            }else if(ch=='*'){
                if(!sb.isEmpty()){
                    sb.deleteCharAt(sb.length()-1);
                }else{
                    continue;
                }
            }
            else if(ch=='#'){
                sb.append(sb.toString());
            }
            else{
                sb.reverse();
            }
        }
        return sb.toString();
    }
}