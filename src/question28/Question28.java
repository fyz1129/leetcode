package question28;

/**
 * @author Dell
 */
public class Question28 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int index = solution.strStr("hello", "aabaa");
        System.out.println(index);
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        //求解next数组
        int[] next = new int[n];
        getNext(next, needle);
        //设置匹配成功的索引
        int j = 0;
        for(int i = 0; i < haystack.length(); i++){
            while(j > 0 && needle.charAt(j) != haystack.charAt(i)){
                j = next[j - 1];
            }
            if(needle.charAt(j) == haystack.charAt(i)){
                j++;
            }
            if(j == needle.length() - 1){
                return i - j + 1;
            }

        }
        return -1;
    }

    public void getNext(int[] next, String needle){
        //初始化，前缀末尾指针
        int j = 0;
        for(int i = 1; i < next.length; i++){
            while(j > 0 && needle.charAt(j) != needle.charAt(i)){
                //System.out.println(j);
                j = next[j - 1];
            }
            if(needle.charAt(j) == needle.charAt(i)){
                j++;
            }
            next[i] = j;

        }
        for (int i : next) {
            System.out.println(i);
        }
    }
}
