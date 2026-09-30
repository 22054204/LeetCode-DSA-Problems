class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] result = new int[n];
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(seq.charAt(i)=='('){
                cnt++;
            }
            result[i] = cnt%2;
            if(seq.charAt(i)==')'){
                cnt--;
            }
        }
        return result;
    }
}