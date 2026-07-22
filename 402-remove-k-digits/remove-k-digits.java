class Solution {
    public String removeKdigits(String s, int k) {
        if(s.length()==k) return "0";
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                while(!stack.isEmpty() && k>0 && stack.peek()>s.charAt(i)){
                    stack.pop();
                    k--;
                }
                stack.push(s.charAt(i));
            }
        }
        while(k>0){
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for(int idx=0;idx<stack.size();idx++){
            sb.append(stack.get(idx));
        }
        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}