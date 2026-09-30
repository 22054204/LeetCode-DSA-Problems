class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];
        int cnt = 0;
        for(int i=0;i<seq.length();i++){
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