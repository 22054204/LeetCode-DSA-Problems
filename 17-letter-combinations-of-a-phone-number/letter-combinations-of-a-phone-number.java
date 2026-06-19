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

        if(digits.length()==1){
            String s1 = map.get(digits.charAt(0)-'0');
            for(int i=0;i<s1.length();i++){
                res.add("" + s1.charAt(i));
            }
        }

        else if(digits.length()==2){
            String s1 = map.get(digits.charAt(0)-'0');
            String s2 = map.get(digits.charAt(1)-'0');
            for(int i=0;i<s1.length();i++){
                for(int j=0;j<s2.length();j++){
                    res.add("" + s1.charAt(i) + s2.charAt(j));

                }
            }
        }

        else if(digits.length()==3){
            String s1 = map.get(digits.charAt(0)-'0');
            String s2 = map.get(digits.charAt(1)-'0');
            String s3 = map.get(digits.charAt(2)-'0');
            for(int i=0;i<s1.length();i++){
                for(int j=0;j<s2.length();j++){
                    for(int k=0;k<s3.length();k++){
                        res.add("" + s1.charAt(i) + s2.charAt(j) + s3.charAt(k));
                    }
                }
            }
        }

        else if(digits.length()==4){
            String s1 = map.get(digits.charAt(0)-'0');
            String s2 = map.get(digits.charAt(1)-'0');
            String s3 = map.get(digits.charAt(2)-'0');
            String s4 = map.get(digits.charAt(3)-'0');
            for(int i=0;i<s1.length();i++){
                for(int j=0;j<s2.length();j++){
                    for(int k=0;k<s3.length();k++){
                        for(int l=0;l<s4.length();l++){
                            res.add("" + s1.charAt(i) + s2.charAt(j) + s3.charAt(k) + s4.charAt(l));
                        }
                    }
                }
            }
        }
        return res;
    }
}