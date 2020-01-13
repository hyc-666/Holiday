package Holiday02;

import java.util.Arrays;

public class Holiday02 {
    public static void main(String[] args) {
//        int[] nums = new int[]{1,3};
//        System.out.println(removeElement(nums,3));
//        System.out.println(Arrays.toString(nums));
        int[] nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums,2));

    }
    //给定一个数组和一个值，原地移除所有给定值,返回数组新长度
    public static int removeElement(int[] nums,int val){
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if(nums[i] == val){
                //所有后边的值往前移动一位
                for (int j = i; j < size - 1; j++) {
                    //这个值依次被后面的值覆盖掉
                    nums[j] = nums[j + 1];
                }
                //删除以后size--
                size--;
                i--;
                continue;
            }
        }
        return size;
    }
    //在一个排序的数组中查找给定值，
    // 查到返回下标，未查到返回应该被插入的位置下标
    public static int searchInsert(int[] nums,int target){
        if(nums.length < 1){
            return 0;
        }
        //假如数组是升序的
        //需要先对数字做范围判断
        if(target > nums[nums.length - 1]){
            return nums.length;
        }
        if(target < nums[0]){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        //采用二分查找法
        while(left < right){
            mid = left + ((right - left) >>> 1);
            if(target < nums[mid]){//在前半部分查找
                right = mid - 1;
            }
            else if(target > nums[mid]){//在后半部分查找
                left = mid + 1;
            }
            else if(target == nums[mid])
                return mid;

        }
        if(right == left){
            return right + 1;
        }
        return right + 1;
    }

}
