class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[5];

        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            if(ch=='b'){
                freq[0]++;
            }
            else if(ch=='a'){
                freq[1]++;
            }
            else if(ch=='l'){
                freq[2]++;
            }
            else if(ch=='o'){
                freq[3]++;
            }
            else if(ch=='n'){
                freq[4]++;
            }
        }
        int ans = 0;
        while(true) {
            if(freq[0] >= 1 && freq[1] >= 1 && freq[2] >= 2 && freq[3] >= 2 && freq[4] >= 1) {
                freq[0]--;
                freq[1]--;
                freq[2] -= 2;
                freq[3] -= 2;
                freq[4]--;

                ans++;
            }
            else {
                break;
            }
        }
        return ans;
    }
}