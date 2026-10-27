class Solution {
    public String[] createGrid(int m, int n) {
        String[] arr = new String[m];
        StringBuilder s = new StringBuilder();
        for(int i=0;i<m;i++){
            s.setLength(0); 
            for(int j=0;j<n;j++){
                if(i==0 || j==n-1) s.append('.');
                else s.append('#');
                arr[i] = s.toString();
            }
        }
        return arr;
    }
}