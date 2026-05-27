class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        while(n>0){
            if(n%3==0 && n%5==0){
                list.add("FizzBuzz");
            }else if (n%3==0){
                list.add("Fizz");
            }else if (n%5==0){
                list.add("Buzz");
            }else{
                list.add(String.valueOf(n));
            }
            n--;
        }
        Collections.reverse(list);
        return list;
    }
}