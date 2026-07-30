class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for(int i=0;i<word.length();i++){
            freq[word.charAt(i)-'a']++;
        }
        Arrays.sort(freq);
        int count = 0;
        for(int i=25;i>=0;i--){
            count+=freq[i]*((i>=18&&i<=25)?1:(i>=10&&i<=17)?2:(i>=2&&i<=9)?3:4);
        }
        return count;
    }
}