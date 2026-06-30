class Solution {
    public int countOfSubstrings(String s, int k) {
        return BruteForce(s, k);
    }
    // public int Optimal(String s, int k) {

    // }
    public int BruteForce(String s, int k) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (check(s, i, j, k)) ans++;
            }
        }
        return ans;
    }
    private static boolean check(String s, int st, int end, int k){
        int[] arr = {0,0,0,0,0,0}; // a e i o u cons
        for(int i=st;i<=end;i++){
            char ch = s.charAt(i);
            if(ch=='a') arr[0]++;
            else if(ch=='e') arr[1]++;
            else if(ch=='i') arr[2]++;
            else if(ch=='o') arr[3]++;
            else if(ch=='u') arr[4]++;
            else arr[5]++;
        }
        return arr[0]>0 && arr[1]>0 && arr[2]>0 && arr[3]>0 && arr[4]>0 && arr[5]==k;
    }
}