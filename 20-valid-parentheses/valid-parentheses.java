class Solution {
    public boolean isValid(String s) {
        int simple_brackets = 0;
        int curly_brackets = 0;
        int square_brackets = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
                if(s.charAt(i)=='(') simple_brackets++;
                if(s.charAt(i)=='{') curly_brackets++;
                if(s.charAt(i)=='[') square_brackets++;      
            }else if(!stack.isEmpty()){
                if(s.charAt(i)==')'){
                    if(stack.pop()!='(') return false;
                    else simple_brackets--;
                }else if(s.charAt(i)=='}'){
                    if(stack.pop()!='{') return false;
                    else curly_brackets--;
                }else if(s.charAt(i)==']'){
                    if(stack.pop()!='[') return false;
                    else square_brackets--;
                }
            }else if(stack.isEmpty()){
                return false;
            }
        }
        return simple_brackets==0 && curly_brackets==0 && square_brackets==0;
    }
}