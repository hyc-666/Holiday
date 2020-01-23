package Holiday09;

import java.util.Arrays;

public class Holiday09 {
    //在数组中找出和为目标值得两个整数，并返回他们得下标
    public static int[] twoSum(int[] nums, int target){
        //才疏学浅，只能用双重循环做
        //现在看见哈希表还头大
        int[] ret = new int[2];
        int i = 0;
        while(i < nums.length) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
            i++;
        }
        return ret;
    }

    public static void main(String[] args) {
//        int[] nums = {-3,4,3,90};
//        System.out.println(Arrays.toString(twoSum(nums,0)));

        String a = "1111";
        String b = "1111";
        String c = addBinary(a,b);
        System.out.println(c);
    }

    //模拟二进制加法
    public static String addBinary(String a, String b){
        int len = Math.max(a.length(),b.length());
        //将两个字符串转换为等长的
        char[] s1 = new char[len];
        for (int i = 0; i < s1.length; i++) {
            s1[i] = '0';
        }
        char[] s2 = new char[len];
        for (int i = 0; i < s2.length; i++) {
            s2[i] = '0';
        }
        char[] s3 = new char[len + 1];
        for (int i = 0; i < s3.length; i++) {
            s3[i] = '0';
        }
        int j = s1.length - 1;
        for (int i = a.length() - 1; i >= 0; i--) {
            s1[j] = a.charAt(i);
            j--;
        }
        j = s2.length - 1;
        for (int i = b.length() - 1; i >= 0; i--) {
            s2[j] = b.charAt(i);
            j--;
        }
        int i = s1.length - 1;
        boolean flag = false;//是否进位
        while(i >= 0){
            if(s1[i] == '0' && s2[i] == '0'){
                if(flag){
                    s3[i + 1] = '1';
                }
                else {
                    s3[i + 1] = '0';
                }
                flag = false;//两个0怎么加都不会有进位
            }
            else if(s1[i] == '0' && s2[i] == '1'){
                if(flag){//根据情况判断是否有进位
                    s3[i + 1] = '0';
                    flag = true;
                }
                else {
                    s3[i + 1] = '1';
                    flag = false;
                }
            }
            else if(s1[i] == '1' && s2[i] == '0'){
                if(flag){
                    s3[i + 1] = '0';
                    flag = true;
                }
                else {
                    s3[i + 1] = '1';
                    flag = false;
                }
            }
            else{
                if(flag){
                    s3[i + 1] = '1';
                }
                else{
                    s3[i + 1] = '0';
                }
                flag = true;//两个1相加本来自带进位
            }
            i--;
        }
        if(!flag){//判断最后一次加法运算有没有发生进位
            char[] ret = new char[len];//没有进位那么需要从新创建这个数组，把开头的0剔除掉
            for (int k = 0; k < ret.length; k++) {
                ret[k] = s3[k + 1];
            }
            return new String(ret);
        }
        s3[0] = '1';//有进位则直接在s3开头补上1
        return new String(s3);
        //先全部化成十进制的数字，相加以后再化成二进制字符串
        //但是很容易溢出
//        long n1 = 0;
//        long n2 = 0;
//        int n = 0;
//        for (int i = a.length() - 1; i >= 0; i--) {
//           if(a.charAt(i) == '1'){
//               n1 = n1 + 1 * (long)Math.pow(2,n);
//           }
//           n++;
//        }
//        n = 0;
//        for (int i = b.length() - 1; i >= 0; i--) {
//            if(b.charAt(i) == '1'){
//                n2 = n2 + 1 * (long)Math.pow(2,n);
//            }
//            n++;
//        }
//        long sum = n1 + n2;
//        int[] ret = new int[len + 1];
//        int i = len;
//        while(sum > 0 && i >= 0){
//            ret[i] = (int)(sum & 1);
//            sum = sum >>> 1;
//            i--;
//        }
//        char[] res = new char[len + 1];
//        for (int j = 0; j < len + 1; j++) {
//            if(ret[j] == 1){
//                res[j] ='1';
//            }
//            else{
//                res[j] = '0';
//            }
//        }
//        if(ret[0] == 0){
//            char[] s = new char[len];
//            for (int j = 0; j < len; j++) {
//                if(ret[j + 1] == 1){
//                    s[j] = '1';
//                }
//                else{
//                    s[j] = '0';
//                }
//            }
//            return new String(s);
//        }
//        return new String(res);
    }
}
