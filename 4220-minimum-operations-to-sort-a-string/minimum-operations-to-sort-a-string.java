class Solution {
    public int minOperations(String s) {
        if(isSorted(s)) return 0;
        if(s.length()==2) return -1;
        int minChar = 'z';
        int maxChar = 'a';
        for(int i=0;i<s.length();i++){
            minChar = (char) Math.min(minChar, s.charAt(i));
            maxChar = (char) Math.max(maxChar, s.charAt(i));
        }
        if(minChar==s.charAt(0) || maxChar==s.charAt(s.length()-1)) return 1;
        if(maxChar==s.charAt(0) && minChar==s.charAt(s.length()-1)){
            int maxCount = 0, minCount = 0;

            for (int i=0;i<s.length();i++) {
                if (s.charAt(i) == maxChar) maxCount++;
                if (s.charAt(i) == minChar) minCount++;
            }

            if (maxCount == 1 && minCount == 1) return 3;
        }
        return 2;
    }
    public boolean isSorted(String s){
        char[] a = s.toCharArray();
        char[] b = a.clone();
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }
}