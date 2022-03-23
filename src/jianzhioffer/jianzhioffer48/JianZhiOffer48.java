package jianzhioffer.jianzhioffer48;

import java.util.HashMap;

/**
 * @author Dell
 */
public class JianZhiOffer48 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxlength = 0;
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                maxlength = maxlength < i - start? i - start : maxlength;
                for(int j = start; j < map.get(s.charAt(i)); j++){
                    map.remove(s.charAt(j));
                }
                start = map.get(s.charAt(i)) + 1;
            }else{
                maxlength = maxlength < i + 1 - start? i + 1 - start : maxlength;
            }
            map.put(s.charAt(i), i);
        }
        return maxlength;
    }
}
