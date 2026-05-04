class Solution {
    public void rotate(int[][] mat) {
        transpose(mat, 0, mat.length-1);
        reverse(mat, 0);
    }
    public void transpose(int[][] mat, int i, int j){
        for(i=0;i<mat.length;i++){
            for(j=i;j<mat[0].length;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
    public void reverse(int[][] mat, int i){
        for(i=0;i<mat.length;i++){
            int left = 0;
            int right = mat.length-1;
            while(left<right){
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}