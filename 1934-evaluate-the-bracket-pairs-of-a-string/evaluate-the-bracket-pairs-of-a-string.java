class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for(int i=0;i<knowledge.size();i++){
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='('){
                int j=i+1;
                StringBuilder search = new StringBuilder();
                while(s.charAt(j)!=')'){
                    search.append(s.charAt(j));
                    j++;
                }
                sb.append(map.getOrDefault(search.toString(), "?"));
                    // if(map.containsKey(search.toString())){
                    //     sb.append(map.get(search.toString()));
                    // }else{
                    //     sb.append('?');
                    // }
                i=j+1;
            }
            else{
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}