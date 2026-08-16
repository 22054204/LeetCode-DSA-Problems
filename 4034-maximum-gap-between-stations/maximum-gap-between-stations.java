class Solution {
    public int maximumGap(String skill, String station) {
        int n = skill.length();
        int m = station.length();

        if(n==1) return 0;

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        // find earliest possible positions
        int idx = 0;
        int i = 0;
        int ii = 0;

        while(i<n){
            while(ii<m && skill.charAt(i)!=station.charAt(ii)){
                ii++;
            }
            arr1[idx++] = ii;
            ii++;
            i++;
        }

        // find latest possible positions
        idx = n-1;
        i = n-1;
        ii = m-1;

        while(i>=0){
            while(ii>=0 && skill.charAt(i)!=station.charAt(ii)){
                ii--;
            }
            arr2[idx--] = ii;
            ii--;
            i--;
        }

        // find max gap
        int max = 0;
        for(int k=0;k<n-1;k++){
            int gap = arr2[k+1]-arr1[k];
            max = Math.max(max, gap);
        }

        return max;
    }
}