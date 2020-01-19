package Holiday05;

import java.util.Arrays;

public class Holiday05 {
    //判断是否在一个整型数组中有重复元素，有返回true，无返回false

    public static boolean containsDuplicate(int[] nums){
        //方法一;套两层循环，比较慢，执行时间355ms
        for (int i = 0; i < nums.length ; i++) {
            int temp = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if(temp == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    //方法二：先排序，再一遍遍历查询是否有存在前后相等的
    //此方法耗时6ms
    public static boolean containsDuplicate_(int[] nums){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String name = "alex";
        String typed = "aaleex";
        System.out.println(isLongPressedName(name,typed));
    }
    //长按键入
    public static boolean isLongPressedName(String name, String typed){
        if(name.length()>typed.length()){
            return false;
        }
        int i = 0;//name中字符的下标
        int j = 0;//typed中字符的下标
        while(i < name.length() && j < typed.length()){
            if(name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }
            else if( j > 0 && typed.charAt(j) == typed.charAt(j - 1)){
                j++;
            }
            else{
                return false;
            }
        }

        return i == name.length();
    }
}
