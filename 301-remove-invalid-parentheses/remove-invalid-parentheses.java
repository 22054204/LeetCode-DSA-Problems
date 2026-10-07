class Solution {
    List<String> result = new ArrayList<>();
    Set<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        solve(s, new StringBuilder(), 0);
        
        int maxLen = 0;
        for(String ele:set){
            if(isValid(ele)){
                maxLen = Math.max(ele.length(), maxLen);
            }
        }

        for(String ele:set){
            if(isValid(ele) && ele.length()==maxLen){
                result.add(ele);
            }
        }

        return result;
    }

    public void solve(String s, StringBuilder sb, int i){
        if(i==s.length()){
            if(isValid(sb.toString())){
                set.add(sb.toString());
            }
            return;
        }

        if(s.charAt(i)>='a' && s.charAt(i)<='z'){
            sb.append(s.charAt(i));
            solve(s, sb, i+1);
            sb.deleteCharAt(sb.length()-1);
        }else{
            // take
            sb.append(s.charAt(i));
            solve(s, sb, i+1);
            sb.deleteCharAt(sb.length()-1);

            // not take
            solve(s, sb, i+1);
        }
    }

    public boolean isValid(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
            }else if(s.charAt(i)==')'){
                count--;
                if(count<0){
                    return false;
                }
            }
        }
        return count==0;
    }
}