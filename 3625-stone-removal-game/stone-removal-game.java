class Solution {
    public boolean canAliceWin(int n) {
        if(n<10) return false;
        else if(n<=18) return true; 
        else if(n<=26) return false;
        else if(n<=33) return true;
        else if(n<=39) return false;
        else if(n<=44) return true;
        else if(n<=48) return false;
        return true; // if(n==49||50)
    }
}