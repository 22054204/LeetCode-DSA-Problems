class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;

        int[][] water = new int[waterStartTime.length][2];
        for(int i=0; i<waterStartTime.length; i++){
            water[i][0] = waterStartTime[i];
            water[i][1] = waterDuration[i];
        }

        Arrays.sort(water, (a,b) -> a[0] - b[0]);

        int m = water.length;
        int[] prefWaterDur = new int[m];
        int[] suffWaterFinish = new int[m];

        prefWaterDur[0] = water[0][1];
        for(int i=1; i<m; i++){
            prefWaterDur[i] = Math.min(prefWaterDur[i-1], water[i][1]);
        }

        suffWaterFinish[m-1] = water[m-1][0] + water[m-1][1];
        for(int i=m-2; i>=0; i--){
            suffWaterFinish[i] = Math.min(suffWaterFinish[i+1], water[i][0] + water[i][1]);
        }

        for(int i=0; i<landStartTime.length; i++){
            int lf = landStartTime[i] + landDuration[i];

            int idx = upperBoundWater(water, lf);

            if(idx > 0){
                ans = Math.min(ans, lf + prefWaterDur[idx-1]);
            }

            if(idx < m){
                ans = Math.min(ans, suffWaterFinish[idx]);
            }
        }

        int[][] land = new int[landStartTime.length][2];
        for(int i=0; i<landStartTime.length; i++){
            land[i][0] = landStartTime[i];
            land[i][1] = landDuration[i];
        }

        Arrays.sort(land, (a,b) -> a[0] - b[0]);

        int n = land.length;
        int[] prefLandDur = new int[n];
        int[] suffLandFinish = new int[n];

        prefLandDur[0] = land[0][1];
        for(int i=1; i<n; i++){
            prefLandDur[i] = Math.min(prefLandDur[i-1], land[i][1]);
        }

        suffLandFinish[n-1] = land[n-1][0] + land[n-1][1];
        for(int i=n-2; i>=0; i--){
            suffLandFinish[i] = Math.min(suffLandFinish[i+1], land[i][0] + land[i][1]);
        }

        for(int i=0; i<waterStartTime.length; i++){
            int wf = waterStartTime[i] + waterDuration[i];

            int idx = upperBoundLand(land, wf);

            if(idx > 0){
                ans = Math.min(ans, wf + prefLandDur[idx-1]);
            }

            if(idx < n){
                ans = Math.min(ans, suffLandFinish[idx]);
            }
        }

        return ans;
    }

    private int upperBoundWater(int[][] arr, int target){
        int l = 0, r = arr.length;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(arr[mid][0] <= target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }

    private int upperBoundLand(int[][] arr, int target){
        int l = 0, r = arr.length;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(arr[mid][0] <= target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }
}