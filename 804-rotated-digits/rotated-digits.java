class Solution {
    public int rotatedDigits(int n) {
        int ans = 0;
        for(int i=1;i<=n;i++){
            if(i==2||i==5||i==6||i==9) ans++;
            else ans += helper(i);
        }
        return ans;
    }
    public static int helper(int a){
        int count = 0;
        while(a>0){
            int x = a%10;
            if(x==3||x==4||x==7) return 0;
            else if(x==2||x==5||x==6||x==9) count=1;
            a = a/10;
        }
        return count;
    }
}