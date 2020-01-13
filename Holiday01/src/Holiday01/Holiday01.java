package Holiday01;

public class Holiday01 {
    //输入一个字符串把字符串中的大写字母转换成小写字母
    public static String toLowerCase(String str) {
        char[] data = str.toCharArray();
        for (int i = 0; i < data.length; i++) {
            if (data[i] >= 'A' && data[i] <= 'Z') {
                data[i] += 32;
            }
        }
        return new String(data);
    }

    public static void main(String[] args) {
        String str = "hEllo Word";
        System.out.println(toLowerCase(str));
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        //rotate(arr,3);
        transform(arr,3);
        display(arr);
    }

    //打印数组
    public static void display(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.print(arr[arr.length - 1] + "]");
    }

    //将数组中的元素向右移动k位，k是非负数
    public static void rotate(int[] nums, int k) {//此代码耗时1~2ms
        //k可能会很大，需要循环移位
        k = k % nums.length;
        //创建新数组长度是原来数组的2倍
        int[] arr = new int[nums.length * 2];
        //新数组前半部分和后半部分用原数组填充
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            arr[i + nums.length] = nums[i];
        }
        //把新数组从第num.length - k位截断赋值给原数组
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[(nums.length - k) + i];
        }
    }
    //解法二：
    //移动一位的时候
    public static void move_one(int[] arr){
        int temp = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }
    public static void transform(int[] arr,int k){//此代码耗时108ms
        k = k % arr.length;
        while(k > 0){
            move_one(arr);
            k--;
        }
    }
}
