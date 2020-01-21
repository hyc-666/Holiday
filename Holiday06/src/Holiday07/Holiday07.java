package Holiday07;

import java.util.Arrays;
import java.util.IllegalFormatCodePointException;

public class Holiday07 {
    //调整数组使偶数位于奇数之前
    public static int[] sortArrayByParity(int[] A){
        //前后双指针法
        int left = 0;
        int right = A.length - 1;
        while(left < right){
            if(A[left] % 2 == 0){//找第一个偶数，如果是循环继续
                left++;
                continue;
            }
            else{//如果是奇数则交换到最后，交换之后再判断交换过来的这个数的奇偶
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                right--;//最后一个奇数已经确定
            }
        }
        return A;
    }

    public static void main(String[] args) {
//        int arr[] = {3,1,2,4};
//        System.out.println(Arrays.toString(sortArrayByParity(arr)));
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }

    //寻找数组中心索引
    public static int pivotIndex(int[] nums){
        int sum = 0;//先计算总和
        int sum_left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            //如果总和减去当前数等于左半边和的2倍，则这个是中心索引
            if(sum - nums[i] == sum_left * 2){
                return i;
            }
            else{
                sum_left += nums[i];
            }
        }
        return -1;
    }
}
