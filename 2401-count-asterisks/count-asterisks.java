class Solution {
    public int countAsterisks(String s) {
        List<List<Character>> list = new ArrayList<>();
        List<Character> miniList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '|') {
                list.add(miniList);
                miniList = new ArrayList<>();
            } else {
                miniList.add(ch);
            }
        }
        if(!miniList.isEmpty()) list.add(miniList);
        int count = 0;
        for(int i=0;i<list.size();i++){
            if(i%2==0){
                List<Character> a = list.get(i);
                for(int j=0;j<a.size();j++){
                    if(a.get(j)=='*'){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}