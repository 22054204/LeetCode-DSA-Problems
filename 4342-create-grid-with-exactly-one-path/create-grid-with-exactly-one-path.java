class Solution {
    public String[] createGrid(int m, int n) {
        String[] result = new String[m];
        Arrays.fill(result, solve(n));
        for(int i=0;i<m;i++){
            StringBuilder a = new StringBuilder();
            for(int j=0;j<result[i].length();j++){
                if(i==0){
                    a.insert(j, '.');
                }else if(j==n-1){
                    a.insert(j, '.');
                }
                else a.append('#');
            }
            result[i] = a.toString();
        }
        return result;
    }
    public String solve(int n){
        int x = n;
        StringBuilder sb = new StringBuilder();
        while(x>0){
            sb.append('#');
            x--;
        }
        return sb.toString();
    }
}