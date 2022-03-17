package question459;

/**
 * @author Dell
 */
public class Question459 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean repeatedSubstringPattern = solution.repeatedSubstringPattern("abababaaba");
        System.out.println(repeatedSubstringPattern);
    }
}

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        //求next数组
        int[] next = new int[n];
        //前缀的末尾，前缀的区间[0,j)
        int j = 0;
        for(int i = 1; i < n; i++){
            while (j > 0 && s.charAt(j) != s.charAt(i)){
                j = next[j - 1];
            }
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        for (int i : next) {
            System.out.println("i = " + i);
        }
        return n % (n - next[n - 1]) == 0 && next[n - 1] != 0 && 2 * next[n - 1] >= n;
    }
}
