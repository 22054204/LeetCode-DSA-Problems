class Solution {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        String t = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                if(!t.isEmpty()){
                    list.add(t);
                }
                t = "";
            }
            else{
                t += s.charAt(i);
            }
        }
        if(!t.isEmpty()) list.add(t);
        swap(list);
        
        String res = "";
        for(int i=0;i<list.size();i++){
            res+=list.get(i) + " ";
        }
        return res.trim();
    }
    private static void swap(List<String> list){
        int i=0;
        int j=list.size()-1;
        while(i<j){
            String temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j,temp);
            i++;
            j--;
        }
    }
}