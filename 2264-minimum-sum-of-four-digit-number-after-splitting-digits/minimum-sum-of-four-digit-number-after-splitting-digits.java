class Solution {
    public int minimumSum(int num) {
        int[] arr = new int[4];
        int idx = 0;
        while(num>0){
            arr[idx++] = num%10;
            num/=10;
        }
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        int sum = 0;
        while(i<j){
            int zzz = (arr[i++]*10)+arr[j--];
            sum+=zzz;
        }
        return sum;
    }
}