class Solution {
    public int minimumPushes(String word) {
        int[] arr = {1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,4,4};
        int[] prefixArr = new int[26];
        prefixArr[0] = arr[0];
        for(int i=1;i<26;i++){
            prefixArr[i] = arr[i]+prefixArr[i-1];
        }
        return prefixArr[word.length()-1];
    }
}