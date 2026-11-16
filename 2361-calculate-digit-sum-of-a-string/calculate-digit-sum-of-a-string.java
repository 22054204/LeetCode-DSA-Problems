class Solution {
    public String digitSum(String s, int k) {
        if(s.length()<=k) return s;

        StringBuilder sb = new StringBuilder(s);
        while(sb.length()>k){
            StringBuilder temp = new StringBuilder();

            for(int i=0;i<sb.length();i+=k){
                int end = Math.min(i + k, sb.length());
                temp.append(findSum(sb.substring(i, end)));
            }
            sb=temp;
        }

        return sb.toString();
    }

    public String findSum(String s){
        int sum = 0;
        for(int i=0;i<s.length();i++){
            sum+=s.charAt(i)-'0';
        }
        return sum+"";
    }
}