class Solution {
    int n;
    int[][] arr;
    long[][] dp;
    int[][][] best;

    public int[] maximumWeight(List<List<Integer>> intervals) {
        n=intervals.size();
        arr=new int[n][4];

        for(int i=0;i<n;i++){
            arr[i][0]=intervals.get(i).get(0);
            arr[i][1]=intervals.get(i).get(1);
            arr[i][2]=intervals.get(i).get(2);
            arr[i][3]=i;
        }

        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));

        dp=new long[n+1][5];
        best=new int[n+1][5][];

        for(int k=0;k<=4;k++){
            best[n][k]=new int[0];
        }

        for(int i=n-1;i>=0;i--){
            best[i][0]=new int[0];

            for(int k=1;k<=4;k++){
                int next=findNext(i);

                long skip=dp[i+1][k];
                long take=arr[i][2]+dp[next][k-1];

                int[] takeIndices=addIndex(best[next][k-1],arr[i][3]);

                if(take>skip){
                    dp[i][k]=take;
                    best[i][k]=takeIndices;
                }else if(take<skip){
                    dp[i][k]=skip;
                    best[i][k]=best[i+1][k];
                }else{
                    dp[i][k]=take;

                    if(compare(takeIndices,best[i+1][k])<0){
                        best[i][k]=takeIndices;
                    }else{
                        best[i][k]=best[i+1][k];
                    }
                }
            }
        }

        return best[0][4];
    }

    int findNext(int i){
        int l=i+1;
        int r=n-1;
        int ans=n;

        while(l<=r){
            int mid=(l+r)/2;

            if(arr[mid][0]>arr[i][1]){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }

        return ans;
    }

    int[] addIndex(int[] a,int index){
        int[] result=new int[a.length+1];

        int i=0,j=0;

        while(i<a.length && a[i]<index){
            result[j++]=a[i++];
        }

        result[j++]=index;

        while(i<a.length){
            result[j++]=a[i++];
        }

        return result;
    }

    int compare(int[] a,int[] b){
        int n=Math.min(a.length,b.length);

        for(int i=0;i<n;i++){
            if(a[i]!=b[i]){
                return Integer.compare(a[i],b[i]);
            }
        }

        return Integer.compare(a.length,b.length);
    }
}