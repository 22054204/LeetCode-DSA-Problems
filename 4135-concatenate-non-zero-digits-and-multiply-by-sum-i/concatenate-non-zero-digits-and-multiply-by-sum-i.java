class Solution {
    public long sumAndMultiply(int n) {
        return Method1(n);
    }
    public long Method1(int n) {
        int rev = 0;
        long sum = 0;
        while(n>0){
            if(n%10==0) n/=10;
            else{
                rev = (rev*10) + (n%10);
                sum += rev%10;
                n /= 10;
            }
        }
        int revToSt = 0;
        while(rev>0){
            revToSt = (revToSt*10) + (rev%10);
            rev /= 10;
        }
        return (long)revToSt*sum;
    }
    public long Method2(int n) {
        if(n==0) return 0;
        String s = String.valueOf(n);
        String t = "";
        long sum = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='0'){
                t+=s.charAt(i);
            }
            sum+=s.charAt(i) - '0';
        }
        long number = Long.parseLong(t);
        return number*sum;
    }
}




















