class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int score = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(score);
                score = 0;
            }else if(s.charAt(i)==')'){

                if(s.charAt(i-1)=='('){ // simple case
                    score = stack.peek() + 1;
                }else{ //nested case
                    score = stack.peek() + 2*score;
                }
                stack.pop();

            }
        }
        return score;
    }
}