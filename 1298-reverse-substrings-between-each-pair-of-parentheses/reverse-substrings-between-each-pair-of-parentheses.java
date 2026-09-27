class Solution {
    public String reverseParentheses(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i < s.length() && j >= 0) {
            while(j >= 0 && s.charAt(j) != '(') j--;
            i = j + 1;
            while(i < s.length() && s.charAt(i) != ')') i++;
            if(j == -1 || i == s.length()) break;
            s = reverse(s, j + 1, i - 1);
            s = s.substring(0, j) + s.substring(j + 1, i) + s.substring(i + 1);
            i = 0;
            j = s.length() - 1;
        }
        return s;
    }
    public String reverse(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        while(i < j) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            i++;
            j--;
        }
        return sb.toString();
    }
}