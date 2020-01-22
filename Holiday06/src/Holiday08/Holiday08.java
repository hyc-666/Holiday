package Holiday08;

import java.net.Inet4Address;
import java.util.Arrays;

public class Holiday08 {
    //数组表示整数加一
    public static int[] plusOne(int[] digits){
//        if(digits.length <= 1){
//            if(digits[0] == 9){
//                digits[0] = 1;
//            }
//            else{
//                digits[0] += 1;
//            }
//            return digits;
//        }
        int i = digits.length - 1;
        while(i >= 0){//如果最后一位是9则有进位
            if(digits[i] == 9){
                digits[i] = 0;
                i--;
            }
            else{
                digits[i] += 1;
                break;
            }
        }
        if(digits[0] == 0){//如果连续进位进到第一位变成0，则应该拓展数组
            int[] nums = new int[digits.length + 1];
            for (int j = 1; j < digits.length; j++) {
                nums[j] = digits[j];
            }
            nums[0] = 1;
            return nums;
        }
        return digits;
    }

    public static void main(String[] args) {
//        int[] nums = {9};
//        System.out.println(Arrays.toString(plusOne(nums)));


        int[] nums = {1,2,2,3};
        System.out.println(thirdMax(nums));
    }
    //返回数组第三大的数
    public static int thirdMax(int[] nums){
//        if(nums.length ==1){
//            return nums[0];
//        }
//        if(nums.length == 2){
//            return nums[0] > nums[1] ? nums[0] : nums[1];
//        }
//        int step = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length - i - 1; j++) {
//                if(nums[j] > nums[j + 1]){
//                    int temp = nums[j];
//                    nums[j] = nums[j + 1];
//                    nums[j + 1] = temp;
//                }
//            }
//            step++;
//            if(step == 3){
//                break;
//            }
//        }
//        return nums[nums.length - 3];

        if(nums.length ==1){
            return nums[0];
        }
        if(nums.length == 2){
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int times = 0;
        int max1 = Integer.MIN_VALUE;//默认最大值
        int max2 = Integer.MIN_VALUE;//默认次大值
        int max3 = Integer.MIN_VALUE;//默认第三大的值
        //每一轮替换掉三个最大值里面的最小值
        boolean one = true;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == Integer.MIN_VALUE && one){
                times++;
                one = false;
            }
            if(nums[i] > max1){//如果比最大值大
                times++;
                max3 = max2;//次大值传给第三大
                max2 = max1;//最大值传给次大值
                max1 = nums[i];//更新最大值
            }
            else if(nums[i] > max2 && nums[i] < max1){//介于最大值与次大值之间
                times++;
                max3 = max2;//次大值变为第三大值
                max2 = nums[i];//更新次大值
            }
            else if(nums[i] > max3 && nums[i] < max2){
                times++;
                max3 = nums[i];//更新第三大的值
            }
        }
        return times >= 3 ? max3: max1;
    }
}
