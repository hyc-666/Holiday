package Holiday11;

public class Holiday11 {
    //验证回文串，只考虑字母和数字，忽略大小写
    public static boolean isPalindrome(String s){
        char[] str = new char[s.length()];
        int count = 0;
        //剔除掉所有非字母和数字
        for (int i = 0; i < s.length(); i++) {
            if((s.charAt(i) >= '0' && s.charAt(i) <= '9')||(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                    ||(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')){
                str[count]  = s.charAt(i);
                count++;
            }
        }
        int left = 0;

        //再把大写统统转为小写
        for (int i = 0; i < count; i++) {
            if(str[i] >= 'A' && str[i] <= 'Z') {
                str[i] += 32;
            }
        }
        //最后验证回文
        count--;
        while (left <count) {
            if (str[left] == str[count]) {
                left++;
                count--;
            } else {
                return false;
            }
        }
        return true;
    }

    //压缩字符串
    public int compress(char[] chars){
        //这个代码我基本上是抄的，理解的不是很透彻，这样子也没有写过
        //好多解题里边都这么写，这种写法头一次见
        int left = 0;
        int size = 0;
        for(int right = 0;right <= chars.length;right++){
            if(chars.length == right || chars[right] != chars[left]){
                chars[size++] = chars[left];
                if(right - left > 1){
                    for(char c : String.valueOf(right - left).toCharArray()){//将连续的字符统计出来然后变成字符
                        chars[size++] = c;
                    }
                }
                left = right;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        String str = "aA";
        System.out.println(isPalindrome(str));
    }
}
