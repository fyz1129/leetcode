package mianshiti50;

import java.util.HashSet;

/**
 * @author Dell
 */
public class MianShiTi50 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("abaccdeff"));
    }
}

class Solution {
    public char firstUniqChar(String s) {
        char result = ' ';
        int slow = 0;
        int fast = 1;
        int n = s.length();
        char[] chars = s.toCharArray();
        HashSet<Character> muiltChar = new HashSet<>();
        while(fast < n){
            //把所有已经出现过的重复字符加入hashset中相当于一个黑名单
            muiltChar.add(chars[fast]);
            while(muiltChar.contains(chars[slow]) && slow < fast - 1){
                slow++;
            }
            System.out.println("slow = " + slow);
            System.out.println("fast = " + fast);
            fast++;
        }
        return chars[slow];
    }
}
