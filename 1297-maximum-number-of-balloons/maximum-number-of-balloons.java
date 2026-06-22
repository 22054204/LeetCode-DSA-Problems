class Solution {
    public int maxNumberOfBalloons(String text) {
        return Method1(text);
    }
    public int Method1(String text) {
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
        // To make one "balloon", we need 2 'l' and 2 'o'.
        // That's why we divide their frequencies by 2.
        freq[2] = freq[2]/2;
        freq[3] = freq[3]/2;
         
        int ans = 0;
        while(true) {
            if(freq[0] >= 1 && freq[1] >= 1 && freq[2] >= 1 && freq[3] >= 1 && freq[4] >= 1) {
                freq[0]--;
                freq[1]--;
                freq[2]--;
                freq[3]--;
                freq[4]--;

                ans++;
            }
            else {
                break;
            }
        }
        return ans;
    }
    public int Method2(String text) {
        List<Character> list = new ArrayList<>();
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)=='b'||text.charAt(i)=='a'||text.charAt(i)=='l'||text.charAt(i)=='l'||text.charAt(i)=='o'||text.charAt(i)=='o'||text.charAt(i)=='n'){
                list.add(text.charAt(i));
            }
        }
        if(list.size()<7) return 0;
        int ans = 0;
        while(!list.isEmpty()){
            int count = 0;
            if(list.contains('b')){
                count++;
                list.remove((Character) 'b');
            }
            if(list.contains('a')){
                count++;
                list.remove((Character) 'a');
            }
            if(list.contains('l')){
                count++;
                list.remove((Character) 'l');
            }
            if(list.contains('l')){
                count++;
                list.remove((Character) 'l');
            }
            if(list.contains('o')){
                count++;
                list.remove((Character) 'o');
            }
            if(list.contains('o')){
                count++;
                list.remove((Character) 'o');
            }
            if(list.contains('n')){
                count++;
                list.remove((Character) 'n');
            }
            if(count==7) ans++;
        }
        return ans;
    }
}