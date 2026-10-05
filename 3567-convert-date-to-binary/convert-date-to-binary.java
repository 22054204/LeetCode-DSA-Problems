class Solution {
    public String convertDateToBinary(String date) {
        return Integer.toBinaryString(Integer.parseInt(date.substring(0, 4)))+'-'+Integer.toBinaryString(Integer.parseInt(date.substring(5, 7)))+'-'+Integer.toBinaryString(Integer.parseInt(date.substring(8, 10)));
    }
}