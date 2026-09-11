class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        solve(n, new StringBuilder(), 0, 0);
        return result;
    }
    public void solve(int n, StringBuilder sb, int open, int close){
        if(sb.length()==n+n){
            result.add(sb.toString());
            return;
        }
        if(open<n){
            solve(n, sb.append('('), open+1, close);
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(close<open){
            solve(n, sb.append(')'), open, close+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}