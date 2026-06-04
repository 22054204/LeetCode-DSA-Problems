class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for(int i=num1;i<=num2;i++){
            ans += helper(i);
        }
        return ans;
    }
    private static int helper(int num){
        String s = String.valueOf(num);
        if(s.length()<3) return 0;
        int ans = 0;
        for(int i=1;i<s.length()-1;i++){
            if((s.charAt(i-1)<s.charAt(i) && s.charAt(i)>s.charAt(i+1)) || (s.charAt(i-1)>s.charAt(i) && s.charAt(i)<s.charAt(i+1))){
                ans++;
            }
        }
        return ans;
    }
}