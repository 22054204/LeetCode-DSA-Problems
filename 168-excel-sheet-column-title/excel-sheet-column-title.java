class Solution {
    public String convertToTitle(int num) {
        char[] arr = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        StringBuilder sb = new StringBuilder();
        if(num<=26){
            sb.append(arr[num-1]);
            return sb.toString();
        }
        while(num>0){
            num--;
            int rem = num%26;
            sb.append(arr[rem]);
            num = num/26;
        }
        return sb.reverse().toString();
    }
}