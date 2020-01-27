package Holiday10;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;

public class Holiday10 {
    //字符串转为数字
    public static int myAtoi(String str){
        //看起来觉得还挺简单的，写起来折磨了我两个多小时
//        int size = 0;
//        int i = 0;
//        boolean has = false;
//        int empty = 0;
//        while(i < str.length()){
//            if(str.charAt(i) == ' '){
//                i++;
//                empty++;
//                continue;
//            }
//            if(!has) {
//                if (str.charAt(i) == '-') {
//                    size++;
//                    i++;
//                    if(i >= str.length()){
//                        break;
//                    }
//                    has = true;
//                }
//                else if(str.charAt(i) == '+'){
//                    size++;
//                    i++;
//                    if(i >= str.length()){
//                        break;
//                    }
//                    has = true;
//                }
//            }
//            if(str.charAt(i) >='0' && str.charAt(i) <= '9'){
//                size++;
//                i++;
//                if(i >= str.length()){
//                    break;
//                }
//                if(str.charAt(i) < '0' || str.charAt(i) > '9'){
//                    break;
//                }
//            }
//            else{
//                break;
//            }
//        }
//        if(size < 1){
//            return 0;
//        }
//        char[] num = new char[size];
//        for (int j = 0; j < size; j++) {
//            num[j] = str.charAt(j + empty);
//        }
//        if(size == 1){
//            if(num[0] == '-' || num[0] =='+') {
//                return 0;
//            }
//        }
//        if(size > 10){
//            if(num[0] == '-'){
//                if(size > 11){
//                    return Integer.MIN_VALUE;
//                }
//            }
//            else if(num[0] == '+'){
//                if(size > 11) {
//                    return Integer.MAX_VALUE;
//                }
//            }
//        }
//        long ret = Long.parseLong(new String(num));
//        if(ret > Integer.MAX_VALUE){
//            return Integer.MAX_VALUE;
//        }
//        if(ret < Integer.MIN_VALUE){
//            return Integer.MIN_VALUE;
//        }
//        return (int)ret;

        char[] arr = str.toCharArray();
        int len = arr.length;
        int flag = 1; //符号位，默认为1
        long ret = 0;//保存最后的结果
        int pos = 0;//个位数，默认为0
        //第一步，确定开始位置
        //确定符号的正负
        int i = 0;
        for(;i< len;i++){
            //发现有符号立马停止
            if(arr[i] == ' '){//有空格则继续
                continue;
            }
            if(arr[i] == '-'){
                i++;
                flag = -1;
                break;
            }
            if(arr[i] == '+'){
                i++;
                break;
            }
            if(arr[i] < '0' || arr[i] > '9'){
                return 0;
            }
            else{
                break;
            }
        }
        //第二步，开始处理数字
        for(;i < len;i++){
            if(arr[i] < '0' || arr[i] > '9'){
                break;
            }
            pos = arr[i] - 48;
//            if(i + 1 >= len){
//                ret = (ret + pos) * flag;
//                if(ret > Integer.MAX_VALUE){
//                    return Integer.MAX_VALUE;
//                }
//                if(ret < Integer.MIN_VALUE){
//                    return Integer.MIN_VALUE;
//                }
//            }
            //ret = ret * flag;
            if(ret > Integer.MAX_VALUE){//这里是没有把符号位算进去的
                //大于整数最大值则退出循环
                //return Integer.MAX_VALUE;
                break;
            }
//            if(ret < Integer.MIN_VALUE){
//                return Integer.MIN_VALUE;
//            }
            ret = ret * 10 + pos;
        }
        ret = ret * flag;//符号位最后算
        if(ret < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        if(ret > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)ret;
    }

    //给定一个升序排列的数组和一个目标值，
    //找出目标值在数组中的开始位置和结束位置
    //没有找到返回[-1,-1]
    public static int[] searchRange(int[] nums, int target){
        //采用二分查找法
        //起码看起来时间复杂度是O(log(n))
        boolean exit = false;
        int index = -1;//找到一个存在对应值的坐标
        int[] ret = new int[2];
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + ((right - left) >>> 1);
            if(target < nums[mid]){//在左半部分
                right = mid - 1;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }
            else{
                exit = true;
                index = mid;
                break;
            }
        }
        if(index < 0){
            ret[0] = -1;
            ret[1] = -1;
            return ret;
        }
        left = index;
        right = index;//从中间往两边查找
        while (left >= 0){
            if(target != nums[left]){
                ret[0] = left + 1;
                break;
            }
            else{
                left--;
            }
        }
        while (right < nums.length){
            if(target != nums[right]){
                ret[1] = right - 1;
                break;
            }
            else
                right++;
        }
        if(left == right){
            ret[0] = left;
            ret[1] = right;
        }
        ret[0] = left + 1;
        ret[1] = right - 1;
        return ret;
    }

    public static void main(String[] args) {
//        String str = "words and 987";
//        System.out.println(myAtoi(str));
        int[] nums = {1,2,2,3};
        System.out.println(Arrays.toString(searchRange(nums,2)));
    }
}
