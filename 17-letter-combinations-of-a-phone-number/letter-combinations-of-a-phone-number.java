class Solution {
    HashMap<Integer,String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        return Method4(digits);
    }


    // Brute Force: HashMap + Nested Loops.
    // Works because digits.length <= 4.
    public List<String> Method1(String digits) {
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


    // Brute Force: Array + Nested Loops.
    // Faster than Method1 due to direct array access.
    public List<String> Method2(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }
        String[] map = {"", "", "abc", "def", "ghi","jkl", "mno", "pqrs", "tuv", "wxyz"};
            //indexes -> 0   1    2      3      4     5     6       7       8      9

        if(digits.length() == 1){
            String s1 = map[digits.charAt(0) - '0'];
            for(int i=0;i<s1.length();i++){
                res.add("" + s1.charAt(i));
            }
        }
        else if(digits.length() == 2){
            String s1 = map[digits.charAt(0) - '0'];
            String s2 = map[digits.charAt(1) - '0'];
            for(int i=0;i<s1.length();i++){
                for(int j=0;j<s2.length();j++){
                    res.add("" + s1.charAt(i) + s2.charAt(j));
                }
            }
        }
        else if(digits.length() == 3){
            String s1 = map[digits.charAt(0) - '0'];
            String s2 = map[digits.charAt(1) - '0'];
            String s3 = map[digits.charAt(2) - '0'];

            for(int i=0;i<s1.length();i++){
                for(int j=0;j<s2.length();j++){
                    for(int k=0;k<s3.length();k++){
                        res.add("" + s1.charAt(i) + s2.charAt(j) + s3.charAt(k));
                    }
                }
            }
        }
        else{
            String s1 = map[digits.charAt(0) - '0'];
            String s2 = map[digits.charAt(1) - '0'];
            String s3 = map[digits.charAt(2) - '0'];
            String s4 = map[digits.charAt(3) - '0'];

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


    // Backtracking using String.
    // Creates a new String at every recursive call.
    public List<String> Method3(String digits) {
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
        Generate2(list,0,"",res);
        return res;
    }
    // Recursive helper for Method3.
    // Picks one character from each mini-list.
    private void Generate2(List<List<Character>> list, int index, String curr, List<String> res){

        if(index == list.size()){
            res.add(curr);
            return;
        }

        List<Character> miniList = list.get(index);
        for(int i=0;i<miniList.size();i++){
            Generate2(list,index+1,curr+miniList.get(i),res);
        }
    }


    // Backtracking using StringBuilder.
    // Faster than Method3 due to fewer String creations.
    public List<String> Method4(String digits) {
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
        Generate1(list,0,new StringBuilder(),res);
        return res;
    }
    // Recursive helper for Method4.
    // Append -> Recurse -> Backtrack.
    private void Generate1(List<List<Character>> list, int index, StringBuilder sb, List<String> res){
        if(index == list.size()){
            res.add(sb.toString());
            return;
        }
        List<Character> miniList = list.get(index);
        for(int i=0;i<miniList.size();i++){
            sb.append(miniList.get(i));
            Generate1(list,index+1,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}