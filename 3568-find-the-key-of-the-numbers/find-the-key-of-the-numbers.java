class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int[] arr1 = {0,0,0,0};
        int[] arr2 = {0,0,0,0};
        int[] arr3 = {0,0,0,0};
        if(num1>=1 && num1<10){
            arr1[3] = num1;
        }else if(num1>=10 && num1<100){
            arr1[3] = num1%10;
            num1/=10;
            arr1[2] = num1%10;
        }else if(num1>=100 && num1<1000){
            arr1[3] = num1%10;
            num1/=10;
            arr1[2] = num1%10;
            num1/=10;
            arr1[1] = num1%10;
        }else if(num1>=1000 && num1<10000){
            arr1[3] = num1%10;
            num1/=10;
            arr1[2] = num1%10;
            num1/=10;
            arr1[1] = num1%10;
            num1/=10;
            arr1[0] = num1%10;
        }

        if(num2>=1 && num2<10){
            arr2[3] = num2;
        }else if(num2>=10 && num2<100){
            arr2[3] = num2%10;
            num2/=10;
            arr2[2] = num2%10;
        }else if(num2>=100 && num2<1000){
            arr2[3] = num2%10;
            num2/=10;
            arr2[2] = num2%10;
            num2/=10;
            arr2[1] = num2%10;
        }else if(num2>=1000 && num2<10000){
            arr2[3] = num2%10;
            num2/=10;
            arr2[2] = num2%10;
            num2/=10;
            arr2[1] = num2%10;
            num2/=10;
            arr2[0] = num2%10;
        }

        if(num3>=1 && num3<10){
            arr3[3] = num3;
        }else if(num3>=10 && num3<100){
            arr3[3] = num3%10;
            num3/=10;
            arr3[2] = num3%10;
        }else if(num3>=100 && num3<1000){
            arr3[3] = num3%10;
            num3/=10;
            arr3[2] = num3%10;
            num3/=10;
            arr3[1] = num3%10;
        }else if(num3>=1000 && num3<10000){
            arr3[3] = num3%10;
            num3/=10;
            arr3[2] = num3%10;
            num3/=10;
            arr3[1] = num3%10;
            num3/=10;
            arr3[0] = num3%10;
        }

        int ans = 0;
        for(int i=0;i<4;i++){
            ans = (ans*10) + Math.min(arr1[i], Math.min(arr2[i], arr3[i]));
        }
        return ans;
    }
}