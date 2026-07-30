class Solution {
    public int minimumPushes(String word) {
        int max = max(word);
        int[] freq = new int[max+1];
        for(int i=0;i<word.length();i++){
            freq[word.charAt(i)-'a']++;
        }
        Arrays.sort(freq);
        freq = reverse(freq);
        int count = 0;
        for(int i=0;i<freq.length;i++){
            if(i>=0 && i<=7) count+=freq[i]*1;
            else if(i>=8 && i<=15) count+=freq[i]*2;
            else if(i>=16 && i<=23) count+=freq[i]*3;
            else count+=freq[i]*4;
        }
        return count;
    }
    private static int max(String word){
        int max = 0;
        for(int i=0;i<word.length();i++){
            max = Math.max(word.charAt(i)-'a', max);
        }
        return max;
    }
    private static int[] reverse(int[] nums){
        int i=0,j=nums.length-1;
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        return nums;
    }
}