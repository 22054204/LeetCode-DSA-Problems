class Solution {
    public long countCommas(long n) {
        if(n<=999) return 0;
        if(n<=999999) return 0 + (n-999)*1L;
        if(n<=999999999) return 999000L + (n-999999)*2L;
        if(n<=999999999999L) return 1998999000L + (n-999999999L)*3L;
        if(n<=999999999999999L) return 2998998999000L + (n-999999999999L)*4L;
        if(n<=999999999999999999L) return 3998998998999000L + (n-999999999999999L)*5L;
        return 0;
    }
}