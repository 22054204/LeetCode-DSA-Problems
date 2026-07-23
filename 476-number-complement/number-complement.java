class Solution {
    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder(s.length());
        for(int i=0;i<s.length();i++){
            sb.append((s.charAt(i)=='0')?'1':'0');
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}