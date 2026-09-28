class Solution {
    public int[] findDegrees(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result[i] += matrix[i][j];
            }
        }
        return result;
    }
}