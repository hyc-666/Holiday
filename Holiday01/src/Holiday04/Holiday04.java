package Holiday04;

import com.sun.xml.internal.stream.StaxErrorReporter;

import java.util.Arrays;

public class Holiday04 {
   //返回最后一个单词的长度（字符串仅包含字母和空格）
    public static int lengthOfLastWord(String s){
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' '){//需要注意末尾空格
                if(length > 0){
                    break;
                }
                continue;
            }
            else{
                length++;
            }
        }
        return length;
    }
    //将两个有序的整数数组合并为一个有序的整数数组
    public static void merge(int[] nums1,int m,int[] nums2,int n){
        //方法一，暴力法，先合并两个数组，然后排序
        if(m == 0){//判断是否第一个数组长度为0
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
        else {//合并
            for (int i = 0; i < n; i++) {
                nums1[i + m] = nums2[i];
            }
        }
        Arrays.sort(nums1);//排序
    }
    public static void merge2(int[] nums1,int[] nums2){

    }

    public static void main(String[] args) {
       int[] nums1 = {1,2,3,0,0,0};
       int[] nums2 = {2,5,6};
       merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
}
