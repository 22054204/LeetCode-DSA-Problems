class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='('){
                if(!stack.isEmpty()){
                    sb.append(s.charAt(i));
                }
                stack.push(s.charAt(i));
            }
            else{
                stack.pop();
                if(!stack.isEmpty()){
                    sb.append(s.charAt(i));
                }
            }
            i++;
        }
        return sb.toString();
    }
}