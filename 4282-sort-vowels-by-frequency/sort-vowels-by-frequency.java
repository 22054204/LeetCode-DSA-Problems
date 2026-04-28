class Solution {
    public String sortVowels(String s) {
        int a = 0, e = 0, i = 0, o = 0, u = 0;

        for(int k=0;k<s.length();k++){
            char ch = s.charAt(k);
            if(ch == 'a') a++;
            else if(ch == 'e') e++;
            else if(ch == 'i') i++;
            else if(ch == 'o') o++;
            else if(ch == 'u') u++;
        }

        int[] first = new int[5];
        for(int k=0;k<5;k++) first[k] = -1;

        for(int k=0;k<s.length();k++){
            char ch = s.charAt(k);
            if(ch=='a' && first[0]==-1) first[0]=k;
            else if(ch=='e' && first[1]==-1) first[1]=k;
            else if(ch=='i' && first[2]==-1) first[2]=k;
            else if(ch=='o' && first[3]==-1) first[3]=k;
            else if(ch=='u' && first[4]==-1) first[4]=k;
        }

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{a, 0, first[0]});
        list.add(new int[]{e, 1, first[1]});
        list.add(new int[]{i, 2, first[2]});
        list.add(new int[]{o, 3, first[3]});
        list.add(new int[]{u, 4, first[4]});

        Collections.sort(list, (x, y) -> {
        if(y[0] != x[0]) return y[0] - x[0];
        return x[2] - y[2];
        });

        StringBuilder vowelOrder = new StringBuilder();

        for(int k=0;k<list.size();k++){
            int[] arr = list.get(k);
            int count = arr[0];
            char ch = 'a';

            if(arr[1] == 0) ch = 'a';
            else if(arr[1] == 1) ch = 'e';
            else if(arr[1] == 2) ch = 'i';
            else if(arr[1] == 3) ch = 'o';
            else ch = 'u';

            while(count > 0){
                vowelOrder.append(ch);
                count--;
            }
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;

        for(int k=0;k<s.length();k++){
            char ch = s.charAt(k);

            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                sb.append(vowelOrder.charAt(idx));
                idx++;
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}