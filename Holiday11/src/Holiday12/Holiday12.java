package Holiday12;

import com.sun.xml.internal.ws.server.ServerRtException;

import java.util.Arrays;

public class Holiday12 {
    //最短无序排序数组
    public static int findUnsortedSubarray(int[] nums){
//        if(nums.length < 2){
//            return 0;
//        }
//        int len = 0;
//        int max = nums[0];
//        int min = nums[nums.length - 1];
//        int high = nums.length - 1;
//        int low = nums.length - 1;
//        for (int i = 1; i < nums.length; i++) {
//           if(max > nums[i]){
//               low = i - 1;
//               break;
//           }
//           else {
//               max = nums[i];
//           }
//        }
//        for (int i = nums.length - 2; i >= 0; i--) {
//            if(min < nums[i]){
//                high = i + 1;
//                break;
//            }
//            else{
//                min = nums[i];
//            }
//        }
//        return low == high ? 0 : high - low + 1;
        int[] arr = new int[nums.length];
        //把原数组复制一遍，然后排序
        //双指针从两头遍历，相等继续，否则返回边界
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != nums[i]){
                left = i;
                break;
            }
            else{
                left++;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] != nums[i]){
                right = i;
                break;
            }
            else{
                right--;
            }
        }
        //如果left > right 则表示两边都不需要排序，返回0
        if(left > right){
            return 0;
        }
        return left == right ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        String[]  str = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(str));
    }

    //逆波兰表达式
    public static int evalRPN(String[] tokens) {
        int[] numStack = new int[tokens.length / 2 + 1];
        //代码抄的，看不懂
        //甚至题目都是看不懂的
        int index = 0;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    numStack[index - 2] += numStack[--index];
                    break;
                case "-":
                    numStack[index - 2] -= numStack[--index];
                    break;
                case "*":
                    numStack[index - 2] *= numStack[--index];
                    break;
                case "/":
                    numStack[index - 2] /= numStack[--index];
                    break;
                default:
                    // numStack[index++] = Integer.valueOf(s);
                    //valueOf改为parseInt，减少自动拆箱装箱操作
                    numStack[index++] = Integer.parseInt(s);
                    break;
            }
        }
        return numStack[0];
    }
}
