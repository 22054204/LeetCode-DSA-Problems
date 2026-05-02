class Solution {
    public int rotatedDigits(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int ans = 0;
        for(int i=0;i<list.size();i++){
            int a = list.get(i);
            if(a==2||a==5||a==6||a==9){
                ans = ans + 1;
            }else{
                ans = ans + helper(a);
            }
        }
        return ans;
    }
    public static int helper(int a){
        int count = 0;
        List<Integer> list = new ArrayList<>();
        while(a>0){
            list.add(a%10);
            a = a/10;
        }
        for(int i=0;i<list.size();i++){
            int x = list.get(i);
            if(x == 3 || x == 4 || x == 7){
                return 0;
            }
            if(x==2||x==5||x==6||x==9){
                count = 1;
            }
        }
        return count;
    }
}