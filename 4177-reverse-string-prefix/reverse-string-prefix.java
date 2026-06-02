class Solution {
    public String reversePrefix(String s, int k) {
        char[] arr = s.toCharArray();
        reverse(arr, 0, k-1);
        return new String(arr);
    }

    private static void reverse(char[] arr, int i, int j){
        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}