class Solution {
    public String convertDateToBinary(String date) {
        String a = Integer.toBinaryString(Integer.parseInt(date.substring(0, 4)));
        String b = Integer.toBinaryString(Integer.parseInt(date.substring(5, 7)));
        String c = Integer.toBinaryString(Integer.parseInt(date.substring(8, 10)));
        return a+'-'+b+'-'+c;
    }
}