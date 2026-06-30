class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        return Optimal(s, n);
    }
    private int Optimal(String s, int n) {
        int ans = 0;
        int i=0;
        int j=0;
        int[] nums = {0,0,0};
        while(i<n && j<n){
            if(s.charAt(j)=='a') nums[0]++;
            else if(s.charAt(j)=='b') nums[1]++;
            else nums[2]++;

            while(nums[0]>0 && nums[1]>0 && nums[2]>0){
                ans+=n-j;
                nums[s.charAt(i) - 'a']--; 
                i++;
            }
            j++;
        }
        return ans;
    }
    public int BruteForce(String s, int n ) {
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=2;j<n;j++){
                if(helper(s, i, j)){
                    ans++;
                }
            }
        }
        return ans;
    }
    private static boolean helper(String s, int st, int end){
        int[] arr = {0,0,0};
        for(int i=st;i<=end;i++){
            int count = 0;
            if(s.charAt(i)=='a') arr[0]++;
            else if(s.charAt(i)=='b') arr[1]++;
            else arr[2]++;
        }
        return arr[0]>0 && arr[1]>0 && arr[2]>0;
    }
}