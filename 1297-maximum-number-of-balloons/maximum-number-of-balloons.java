class Solution {
    public int maxNumberOfBalloons(String text) {
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