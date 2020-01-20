package Holiday06;

import java.util.Arrays;

public class Holiday06 {
    //有序数组平方后的排序
    public static int[] sortedSquares(int[] A){
        //方法一，简单粗暴，先平方，后排序
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }
    //反转字符串，只反转字母
    public static String reverseOnlyLetters(String S){
        //双指针法
        int left = 0;
        int right = S.length() - 1;
        char[] str = S.toCharArray();
        while(left < right){
            if((str[left] >= 'A' && str[left] <= 'Z')//确定左边第一个字母
                    ||(str[left] >= 'a' && str[left] <= 'z')){
                if((str[right] >= 'A' && str[right] <= 'Z')//确定右边第一个字母
                        ||(str[right] >= 'a' && str[right] <= 'z')){//确定后交换
                    char temp = str[left];
                    str[left] = str[right];
                    str[right] = temp;
                }
                else {//从右边倒着找字母
                    right--;
                    continue;
                }
            }
            else{//从左边顺着找字母
                left++;
                continue;
            }
            left++;
            right--;
        }
        return new String(str);
    }
    public static void main(String[] args) {
//        int[] A = {-4,-1,0,3,10};
//        sortedSquares(A);
//        System.out.println(Arrays.toString(A));
        String S = "a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(S));
    }
}
