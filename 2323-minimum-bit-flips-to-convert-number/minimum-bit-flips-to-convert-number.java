class Solution {
    public int minBitFlips(int start, int goal) {
        String a = Integer.toBinaryString(start);
        String b = Integer.toBinaryString(goal);
        if(a.length()>b.length()){
            StringBuilder sb = new StringBuilder(b);
            sb.reverse();
            while(sb.length()!=a.length()){
                sb.append('0');
            }
            b = sb.reverse().toString();
        }else{
            StringBuilder sb = new StringBuilder(a);
            sb.reverse();
            while(sb.length()!=b.length()){
                sb.append('0');
            }
            a = sb.reverse().toString();
        }
        int count=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)) count++;
        }
        return count;
    }
}