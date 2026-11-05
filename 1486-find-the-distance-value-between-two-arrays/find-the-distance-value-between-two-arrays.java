class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int result = 0;
        for(int num1:arr1){
            boolean valid = true;
            for(int num2:arr2){
                int diff = Math.abs(num1-num2);
                if(diff<=d) valid = false;
            }
            if(valid) result++;
        }
        return result;
    }
}