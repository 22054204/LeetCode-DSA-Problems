class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        List<List<Character>> list = new ArrayList<>();
        for(int i=0;i<digits.length();i++){
            List<Character> miniList = new ArrayList<>();
            String s = map.get(Integer.parseInt("" + digits.charAt(i)));
            for(int j=0;j<s.length();j++){
                miniList.add(s.charAt(j));
            }
            list.add(miniList);
        }
        Generate(list,0,"",res);
        return res;
    }
    public void Generate(List<List<Character>> list, int index, String curr, List<String> res){

        if(index == list.size()){
            res.add(curr);
            return;
        }

        List<Character> miniList = list.get(index);
        for(int i=0;i<miniList.size();i++){
            Generate(list,index+1,curr+miniList.get(i),res);
        }
    }
}