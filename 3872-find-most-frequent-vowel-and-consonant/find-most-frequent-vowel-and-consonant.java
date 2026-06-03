class Solution {
    public int maxFreqSum(String s) {
        List<Character> list1 = new ArrayList<>(); // [u,e,e]
        List<Character> list2 = new ArrayList<>(); //[s,c,c,s,s,s]
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                list1.add(ch);
            }else{
                list2.add(ch);
            }
        }
        //System.out.println("list1 "+list1);
        //System.out.println("list2 "+list2);

        List<Integer> list3 = new ArrayList<>();
        for(int i=0;i<list1.size();i++){
            int count = 0;
            for(int j=i;j<list1.size();j++){
                if(list1.get(i)==list1.get(j)){
                    count++;
                }
            }
            list3.add(count);
        }
        //System.out.println("list3 "+list3);

        List<Integer> list4 = new ArrayList<>();
        for(int i=0;i<list2.size();i++){
            int count = 0;
            for(int j=i;j<list2.size();j++){
                if(list2.get(i)==list2.get(j)){
                    count++;
                }
            }
            list4.add(count);
        }
        //System.out.println("list4 "+list4);

        // find max in list3
        int max1 = 0;
        for(int i=0;i<list3.size();i++){
            max1 = Math.max(max1, list3.get(i));
        }
        //System.out.println("max1 "+max1);

        // find max in list3
        int max2 = 0;
        for(int i=0;i<list4.size();i++){
            max2 = Math.max(max2, list4.get(i));
        }
        //System.out.println("max2 "+ max2);

        return max1+max2;
    }
}