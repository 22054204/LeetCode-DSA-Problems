class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int cnt = 0;
        int i=0;
        char[] arr = s.toCharArray();
        while(i<arr.length-1){
            char ch = arr[i];
            if(ch=='('){
                cnt++;
                i++;
            }else if(ch==')' && arr[i+1]==')' && cnt==0){
                ans+=1;
                i+=2;
            }else if(ch==')' && arr[i+1]==')' && cnt!=0){
                cnt--;
                i+=2;
            }
            else if(ch==')' && cnt==0){
                ans+=2;
                i++;
            }else if(ch==')' && cnt!=0){
                ans+=1;
                cnt--;
                i++;
            }
        }
        if(i < arr.length){ // i is at last index
            if(arr[i]=='('){
                ans+=2;
            }else if(arr[i]==')' && cnt!=0){
                ans+=1;
                cnt--;
            }else if(arr[i]==')' && cnt==0){
                ans+=2;
            }
        }
        return cnt*2 + ans;
    }
}