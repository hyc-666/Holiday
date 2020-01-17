package Holiday03;

public class Holiday03 {
    //判断字符串一当中的字符能不能由字符串2中的字符组成，每个字符只能使用一次
    public static boolean canConstruct(String ransomNote,String magazine){
        int key = 0;
        if(ransomNote.length() <= 0){
            return true;
        }
        if(ransomNote.length() > 0 && magazine.length() <= 0){
            return false;
        }
        char[] str1 = ransomNote.toCharArray();
        char[] str2 = magazine.toCharArray();
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                if(str1[i] == str2[j]){
                    key++;
                    if(key == str1.length){
                        return true;
                    }
                    str2[j] = '=';
                    break;
                }
            }
        }

        return false;

    }
    //判断一个整数是不是回文数
    public static boolean isPalindRome(int x){
//        if(x >= 0 && x < 10){
//            return true;
//        }
        String str = "" + x;
        int left = 0;
        int right = str.length() - 1;
        while(left <= right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
