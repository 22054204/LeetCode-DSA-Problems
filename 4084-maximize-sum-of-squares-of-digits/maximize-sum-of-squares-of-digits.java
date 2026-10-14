class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > num*9) return "";
        StringBuilder sb = new StringBuilder();
        int nines = sum / 9;
        int rem = sum % 9;

        while(nines--!=0) sb.append('9');
        if(rem>0) sb.append(rem);
        while(sb.length()<num) sb.append('0');
        return sb.toString();
    }
}