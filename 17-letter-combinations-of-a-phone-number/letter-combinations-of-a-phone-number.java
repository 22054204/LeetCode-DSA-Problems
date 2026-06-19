class Solution {
    HashMap<Integer,String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        Generate(digits,0,new StringBuilder(),res);
        return res;
    }
    public void Generate(String digits, int index, StringBuilder sb, List<String> res){

        if(index==digits.length()){
            res.add(sb.toString());
            return;
        }

        String s = map.get(digits.charAt(index)-'0');
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            Generate(digits,index+1,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}