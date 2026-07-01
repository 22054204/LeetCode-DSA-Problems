class Solution {
    public long countOfSubstrings(String s, int k) {
        return Optimal(s, k);
    }
    public long Optimal(String s, int k) {
        // in this solution i precompute cons indexes and store it in array
        int n = s.length();
        int[] nextCons = new int[n];
        int last = n;
        for (int i = n-1;i>=0;i--) {
            nextCons[i] = last;
            if (!isVowel(s, i)) {
                last = i;
            }
        }

        int[] arr = {0,0,0,0,0,0}; //a e i o u cons 
        int i=0;
        int j=0;
        long ans = 0;
        while(j<n){
            char ch = s.charAt(j);
            if(ch=='a') arr[0]++;
            else if(ch=='e') arr[1]++;
            else if(ch=='i') arr[2]++;
            else if(ch=='o') arr[3]++;
            else if(ch=='u') arr[4]++;
            else arr[5]++;

            while (i<=j && arr[5] > k) {
                char ch1 = s.charAt(i);
                if(ch1=='a') arr[0]--;
                else if(ch1=='e') arr[1]--;
                else if(ch1=='i') arr[2]--;
                else if(ch1=='o') arr[3]--;
                else if(ch1=='u') arr[4]--;
                else arr[5]--;
                i++;   
            }

            while(i<=j && arr[0]>0 && arr[1]>0 && arr[2]>0 && arr[3]>0 && arr[4]>0 && arr[5]==k){
                int idx = nextCons[j];
                ans+=(long)(idx-j);

                char ch1 = s.charAt(i);
                if (ch1 == 'a') arr[0]--;
                else if (ch1 == 'e') arr[1]--;
                else if (ch1 == 'i') arr[2]--;
                else if (ch1 == 'o') arr[3]--;
                else if (ch1 == 'u') arr[4]--;
                else arr[5]--;    

                i++;         
            }
            j++;
        }
        return ans;
    }
    public long Better(String s, int k) {
        int[] arr = {0,0,0,0,0,0}; //a e i o u cons 
        int i=0;
        int j=0;
        int n = s.length();
        long ans = 0;
        while(i<=j && j<n){
            char ch = s.charAt(j);
            if(ch=='a') arr[0]++;
            else if(ch=='e') arr[1]++;
            else if(ch=='i') arr[2]++;
            else if(ch=='o') arr[3]++;
            else if(ch=='u') arr[4]++;
            else arr[5]++;

            while (arr[5] > k) {
                char ch1 = s.charAt(i);
                if(ch1=='a') arr[0]--;
                else if(ch1=='e') arr[1]--;
                else if(ch1=='i') arr[2]--;
                else if(ch1=='o') arr[3]--;
                else if(ch1=='u') arr[4]--;
                else arr[5]--;
                i++;   
            }

            while(arr[0]>0 && arr[1]>0 && arr[2]>0 && arr[3]>0 && arr[4]>0 && arr[5]==k){
                int a = j;
                while(a+1<n && isVowel(s, a+1)){
                    a++;
                }
                ans+=(long)(a-j+1);
                char ch1 = s.charAt(i);

                if (ch1 == 'a') arr[0]--;
                else if (ch1 == 'e') arr[1]--;
                else if (ch1 == 'i') arr[2]--;
                else if (ch1 == 'o') arr[3]--;
                else if (ch1 == 'u') arr[4]--;
                else arr[5]--;    

                i++;         
            }
            j++;
        }
        return ans;
    }
    private static boolean isVowel(String s, int j){
        char ch = s.charAt(j);
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')  return true;
        return false;
    }
    public long BruteForce(String s, int k) {
        int n = s.length();
        long ans = 0;
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