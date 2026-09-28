class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];
        int[] ones = new int[n];
        int idx = 0;
        for(int i=0;i<n;i++){
            if(boxes.charAt(i)=='1'){
                ones[idx++] = i;
            }
        }
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=0;j<idx;j++){
                sum += Math.abs(ones[j]-i);
            }
            result[i] = sum;
        }
        return result;
    }
}