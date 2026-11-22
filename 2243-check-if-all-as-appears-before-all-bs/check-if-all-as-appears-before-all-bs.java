class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        int i=n-1;
        while(i>=0 && s.charAt(i)!='a'){
            i--;
        }
        if(i<0) return true;
        while(i>=0 && s.charAt(i)!='b'){
            i--;
        }
        if(i<0) return true;
        return false;
    }
}