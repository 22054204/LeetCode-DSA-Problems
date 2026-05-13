class Solution {
    public int mySqrt(int x) {
        return BinarySearch(x);
    }
    // using Binary Search
    public int BinarySearch(int x){
        if (x < 2) return x;
        int start = 1;
        int end = x; // you also take end = x/2 , because its obvious ... like x = 9 , root9 <= 9/2;  So searching above x/2 is guaranteed useless...
        int ans = 1;
        while(start <= end){
            int mid = start+(end-start)/2;
            if(mid <= x/mid){ // you might write (mid <= x/mid) this ... because for bigger value of x this (mid*mid <= x) may overflow
                ans = mid;
                start = mid+1;
            }else {
                end = mid - 1;
            }
        }
        return ans;
    }
    // linear Search approach
    public int LinearSearch(int x){
        if(x<2) return x;
        long i=1;
        while(i*i <= x){
            i++;
        }
        return (int) i-1;
    }
    //Newton’s Method
    public int NewtonMethod(int x){
        if(x<2) return x;
        long a = x;
        while(a*a>x){
            a = (a + x/a) / 2;
        }
        return (int) a;
    }
    // But you can't use inbuild Math.sqrt(), This is cheating
    public int InbuildFunction(int x) {
        int number = (int) Math.sqrt(x);
        return number;
    }
}

