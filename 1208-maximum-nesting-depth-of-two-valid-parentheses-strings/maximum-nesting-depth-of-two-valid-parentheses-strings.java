class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];
        int cnt = 0;
        for(int i=0;i<seq.length();i++){
            if(seq.charAt(i)=='('){
                cnt++;
            }
            if(cnt%2==0){
                result[i]=0;
            }else{
                result[i]=1;
            }
            if(seq.charAt(i)==')'){
                cnt--;
            }
        }
        return result;
    }
}