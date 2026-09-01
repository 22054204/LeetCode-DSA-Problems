class Solution {
    public int xorOperation(int n, int start) {
        int a = start+2*0;
        int i=1;
        int zor = a;
        while(i<n){
            int b = start+2*i;
            zor^=b;
            i++;
        }
        return zor;
    }
}