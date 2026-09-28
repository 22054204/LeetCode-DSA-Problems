class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];

        int count = 0;
        for(int i=0;i<n;i++){
            if(boxes.charAt(i)=='1') count++;
        }
        int[] ones = new int[count];
        int idx = 0;
        for(int i=0;i<n;i++){
            if(boxes.charAt(i)=='1'){
                ones[idx++] = i;
            }
        }
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=0;j<count;j++){
                sum += Math.abs(ones[j]-i);
            }
            result[i] = sum;
        }
        return result;
    }
}