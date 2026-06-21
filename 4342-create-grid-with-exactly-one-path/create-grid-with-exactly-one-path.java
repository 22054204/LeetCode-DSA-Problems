class Solution {
    public String[] createGrid(int m, int n) {
        String[] arr = new String[m];
        String s = "";
        for(int i=0;i<m;i++){
            s = "";
            for(int j=0;j<n;j++){
                if(i==0 || j==n-1) s+='.';
                else s+='#';
                arr[i] = s;
            }
        }
        return arr;
    }
}